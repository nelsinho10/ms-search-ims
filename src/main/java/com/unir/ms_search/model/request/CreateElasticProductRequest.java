package com.unir.ms_search.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateElasticProductRequest {
    
    private String name;
    private String description;
    private String category;
    private String brand;
    private String model;
    private Double price;
    private Integer stock;
}
