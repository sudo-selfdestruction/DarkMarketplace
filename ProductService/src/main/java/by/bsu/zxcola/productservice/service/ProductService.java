package by.bsu.zxcola.productservice.service;

import by.bsu.zxcola.productservice.entity.Product;
import by.bsu.zxcola.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product findById (Long id) {
        Product product = productRepository.findById(id).orElse(null);

        return product;
    }

    public Product findByName (String name) {
        Product product = productRepository.findProductByName(name);

        return product;
    }

    public Product addProduct (Product product) {
        Product newProduct = productRepository.save(product);

        return newProduct;
    }

    public Product updateProduct (Product oldProduct, Product updatedProduct) {
        oldProduct.setName(updatedProduct.getName());
        oldProduct.setDescription(updatedProduct.getDescription());
        oldProduct.setManufacturingCountry(updatedProduct.getManufacturingCountry());
        oldProduct.setCost(updatedProduct.getCost());
        oldProduct.setWeight(updatedProduct.getWeight());
        productRepository.save(oldProduct);

        return updatedProduct;
    }

    public void deleteProduct (Long id) {
        productRepository.deleteById(id);
    }
}
