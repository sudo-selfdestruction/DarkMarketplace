package by.bsu.zxcola.productservice.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String manufacturingCountry;
    private int cost;
    private double weight;
}
