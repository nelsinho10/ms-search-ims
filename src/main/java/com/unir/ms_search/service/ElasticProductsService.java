package com.unir.ms_search.service;

import java.util.List;

import com.unir.ms_search.controller.CreateStockController;
import com.unir.ms_search.model.pojo.ElasticProduct;
import com.unir.ms_search.model.request.CreateElasticProductRequest;

public interface ElasticProductsService {
    ElasticProduct createProduct(CreateElasticProductRequest request);
    List<ElasticProduct> updateStock(CreateStockController[] request);
    ElasticProduct getProductById(String productId);
    ElasticProduct getProductByName(String productName);
    List<ElasticProduct> getProducts();
    List<ElasticProduct> getProductsByCategory(String category);
    List<ElasticProduct> getProductsByBrand(String brand);
    List<ElasticProduct> getProductsByModel(String model);
    List<ElasticProduct> searchProductsByName(String productName);
    List<ElasticProduct> searchProductsByDescription(String description);
   
}
