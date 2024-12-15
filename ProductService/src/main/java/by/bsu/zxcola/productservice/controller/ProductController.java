package by.bsu.zxcola.productservice.controller;

import by.bsu.zxcola.productservice.entity.Product;
import by.bsu.zxcola.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/product")
    public List<Product> getProduct() {
        return productService.getAllProducts();
    }
}
