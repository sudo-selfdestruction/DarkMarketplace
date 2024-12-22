package by.bsu.zxcola.productservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "marketplace-service"/*, url = "http://MarketplaceService:8082/"*/)
public interface MarketplaceServiceFeignClient {
    @PostMapping("/list_product")
    void addProductToMarketplace(Long productId);
    @GetMapping("/marketplace/test")
    Integer getOne();
    @PostMapping("/order/{id}")
    String addOrder(@PathVariable String id);
}
