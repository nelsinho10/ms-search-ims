package com.unir.ms_search.controller;

import org.springframework.web.bind.annotation.RestController;

import com.unir.ms_search.model.pojo.ElasticProduct;
import com.unir.ms_search.model.request.CreateElasticProductRequest;
import com.unir.ms_search.service.ElasticProductsService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class ElasticProductController {

    private final ElasticProductsService service;

    @GetMapping("/elastic/products")
    public ResponseEntity<List<ElasticProduct>> getProducts() {
        List<ElasticProduct> products = service.getProducts();

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(products);
    }

    @PostMapping("/elastic/products")
    public ResponseEntity<ElasticProduct> createProduct(@RequestBody CreateElasticProductRequest request) {

        ElasticProduct product = service.createProduct(request);

        if (product == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(product);

    }

    @GetMapping("/elastic/products/{id}/details")
    public ResponseEntity<ElasticProduct> getProductById(@PathVariable String id) {
        ElasticProduct product = service.getProductById(id);

        if (product == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(product);
    }

    @PostMapping("/elastic/products/stock")
    public ResponseEntity<List<ElasticProduct>> updateStock(@RequestBody CreateStockController[] request) {
        List<ElasticProduct> product = service.updateStock(request);

        if (product == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(product);
    }

    @GetMapping("/elastic/products/search")
    public ResponseEntity<List<ElasticProduct>> searchProductsByName(@RequestParam String productName) {
        List<ElasticProduct> products = service.searchProductsByName(productName);

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(products);
    }

}
