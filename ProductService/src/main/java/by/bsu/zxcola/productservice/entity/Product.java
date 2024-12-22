package by.bsu.zxcola.productservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "manufacturing_country")
    private String manufacturingCountry;

    @Column(name = "cost")
    private int cost;

    @Column(name = "weight")
    private double weight;

    @Column(name = "quantity")
    private Long quantity;

}
