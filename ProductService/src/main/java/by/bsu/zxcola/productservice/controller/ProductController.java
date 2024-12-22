package by.bsu.zxcola.productservice.controller;

import by.bsu.zxcola.productservice.dto.ProductDto;
import by.bsu.zxcola.productservice.entity.Product;
import by.bsu.zxcola.productservice.feign.MarketplaceServiceFeignClient;
import by.bsu.zxcola.productservice.mapper.ProductMapper;
import by.bsu.zxcola.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class ProductController {
    @Autowired
    private final ProductService productService;
    @Autowired
    private MarketplaceServiceFeignClient marketplaceServiceFeignClient;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/")
    public List<ProductDto> getProduct() {
        List<ProductDto> productDtoList =
                productMapper.convertProductListToProductDtoList(productService.getAllProducts());
        return productDtoList;
    }
    @GetMapping("/marketplace/test")
    public Integer getOne() {
        return marketplaceServiceFeignClient.getOne();
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.convertProductDtoToProduct(productDto);
        productService.addProduct(product);
        return productDto.toString();
    }

    @PostMapping("/order/{id}")
    public ProductDto addOrder(@PathVariable String id) {
        Long productId = Long.parseLong(id);
        if (productService.findById(productId) != null) {
            marketplaceServiceFeignClient.addOrder(id);
        }
        return productMapper.convertProductToProductDto(productService.findById(productId));
    }

}
