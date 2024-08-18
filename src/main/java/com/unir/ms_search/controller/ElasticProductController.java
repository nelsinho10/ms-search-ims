package com.unir.ms_search.controller;

import org.springframework.web.bind.annotation.RestController;

import com.unir.ms_search.model.pojo.ElasticProduct;
import com.unir.ms_search.model.request.CreateElasticProductRequest;
import com.unir.ms_search.service.ElasticProductsService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
