package by.bsu.zxcola.productservice.repository;

import by.bsu.zxcola.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {
    Product findProductByName(String name);
}