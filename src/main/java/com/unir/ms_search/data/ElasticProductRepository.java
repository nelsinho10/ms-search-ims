package com.unir.ms_search.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.unir.ms_search.model.pojo.ElasticProduct;

public interface ElasticProductRepository extends ElasticsearchRepository<ElasticProduct, String> {
    Optional<ElasticProduct> findByName(String name);
    List<ElasticProduct> findByCategory(String category);
    List<ElasticProduct> findByBrand(String brand);
    List<ElasticProduct> findByEnabled(Boolean enabled);
    ElasticProduct save(ElasticProduct product);
    ElasticProduct findById(String id);
}
