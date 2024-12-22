package by.bsu.zxcola.productservice.mapper;

import by.bsu.zxcola.productservice.dto.ProductDto;
import by.bsu.zxcola.productservice.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ProductDto convertProductToProductDto (Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    public Product convertProductDtoToProduct (ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return product;
    }

    public List<ProductDto> convertProductListToProductDtoList (List<Product> productList) {
        List<ProductDto> productDtoList = new ArrayList<ProductDto>();

        for (Product product : productList) {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setDescription(product.getDescription());
            productDto.setManufacturingCountry(product.getManufacturingCountry());
            productDto.setCost(product.getCost());
            productDto.setWeight(product.getWeight());

            productDtoList.add(productDto);
        }

        return productDtoList;
    }
}