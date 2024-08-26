package com.unir.ms_search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unir.ms_search.controller.CreateStockController;
import com.unir.ms_search.data.ElasticSearchRepository;
import com.unir.ms_search.model.pojo.ElasticProduct;
import com.unir.ms_search.model.request.CreateElasticProductRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ElasticProductsServiceImpl implements ElasticProductsService {

    private final ElasticSearchRepository repository;

    @Override
    public ElasticProduct createProduct(CreateElasticProductRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        ElasticProduct product = ElasticProduct.builder()
                .name(request.getName())
                .description(request.getDescription())
                .category(request.getCategory())
                .brand(request.getBrand())
                .model(request.getModel())
                .price(request.getPrice())
                .stock(request.getStock())
                .supplier(request.getSupplier())
                .enabled(true)
                .build();

        return repository.saveProduct(product);
    }

    @Override
    public ElasticProduct getProductById(String productId) {
        return repository.getProductById(productId);
    }

    @Override
    public List<ElasticProduct> updateStock(CreateStockController[] request) {

        List<ElasticProduct> products = new ArrayList<>();

        // Iterate over the request array
        for (CreateStockController pr : request) {
            // Get the product by id
            ElasticProduct product = repository.getProductById(pr.getProductId());
            // Update the stock
            product.setStock(pr.getStock());
            repository.saveProduct(product);
            products.add(product);
        }
        return products;
    }

    @Override
    public List<ElasticProduct> getProducts() {
        return repository.getProducts();
    }

    @Override
    public List<ElasticProduct> searchProductsByName(String productName) {
        return repository.searchProductsByName(productName);
    }

}
