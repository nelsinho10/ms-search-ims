package com.unir.ms_search.model.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(indexName = "product", createIndex = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElasticProduct {

    @Id
    private String id;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "name"), otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type))
    private String name;

    @Field(type = FieldType.Text, name = "description")
    private String description;

    @Field(type = FieldType.Keyword, name = "category")
    private String category;

    @Field(type = FieldType.Keyword, name = "brand")
    private String brand;

    @Field(type = FieldType.Keyword, name = "model")
    private String model;

    @Field(type = FieldType.Double, name = "price")
    private Double price;

    @Field(type = FieldType.Integer, name = "stock")
    private Integer stock;

    @Field(type = FieldType.Boolean, name = "enabled")
    private Boolean enabled;

}
