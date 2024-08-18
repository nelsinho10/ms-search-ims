package com.unir.ms_search.data;

import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Component;

import com.unir.ms_search.model.pojo.ElasticProduct;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ElasticSearchRepository {

    private final String[] nameSearchFields = { "name.search", "name.search._2gram", "name.search._3gram" };
    private final ElasticProductRepository productRepository;
    private final ElasticsearchOperations elasticClient;

    public List<ElasticProduct> getProducts() {
        return productRepository.findByEnabled(true);
    }

    public ElasticProduct saveProduct(ElasticProduct product) {
        return productRepository.save(product);
    }

    public List<ElasticProduct> searchProductsByName(String namePart) {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.multiMatchQuery(namePart, nameSearchFields).type(
                MultiMatchQueryBuilder.Type.BOOL_PREFIX));

        NativeSearchQueryBuilder searchQuery = new NativeSearchQueryBuilder().withQuery(boolQuery);
        Query query = searchQuery.build();

        SearchHits<ElasticProduct> result = elasticClient.search(query, ElasticProduct.class);
        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

}
