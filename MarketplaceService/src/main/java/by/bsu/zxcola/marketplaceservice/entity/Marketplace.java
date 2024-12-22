package by.bsu.zxcola.marketplaceservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Marketplace")
public class Marketplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "address")
    private String address;

    public Marketplace(Long id) {
        this.productId = id;
    }
}