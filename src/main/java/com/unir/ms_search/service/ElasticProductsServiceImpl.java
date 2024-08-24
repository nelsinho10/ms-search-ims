package com.unir.ms_search.service;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.common.recycler.Recycler.C;
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
    public ElasticProduct getProductByName(String productName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductByName'");
    }

    @Override
    public List<ElasticProduct> getProducts() {
        return repository.getProducts();
    }

    @Override
    public List<ElasticProduct> getProductsByCategory(String category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByCategory'");
    }

    @Override
    public List<ElasticProduct> getProductsByBrand(String brand) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByBrand'");
    }

    @Override
    public List<ElasticProduct> getProductsByModel(String model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductsByModel'");
    }

    @Override
    public List<ElasticProduct> searchProductsByName(String productName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchProductsByName'");
    }

    @Override
    public List<ElasticProduct> searchProductsByDescription(String description) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchProductsByDescription'");
    }

}
