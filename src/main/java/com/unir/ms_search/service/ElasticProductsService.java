package com.unir.ms_search.service;

import java.util.List;

import com.unir.ms_search.controller.CreateStockController;
import com.unir.ms_search.model.pojo.ElasticProduct;
import com.unir.ms_search.model.request.CreateElasticProductRequest;

public interface ElasticProductsService {
    ElasticProduct createProduct(CreateElasticProductRequest request);
    List<ElasticProduct> updateStock(CreateStockController[] request);
    ElasticProduct getProductById(String productId);
    List<ElasticProduct> getProducts();
    List<ElasticProduct> searchProductsByName(String productName);
   
}
