package by.bsu.zxcola.marketplaceservice.controller;

import by.bsu.zxcola.marketplaceservice.dto.MarketplaceDto;
import by.bsu.zxcola.marketplaceservice.entity.Marketplace;
import by.bsu.zxcola.marketplaceservice.mapper.MarketplaceMapper;
import by.bsu.zxcola.marketplaceservice.service.MarketplaceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MarketplaceController {
    @Autowired
    private MarketplaceService marketplaceService;

    @Autowired
    private MarketplaceMapper marketplaceMapper;


    @GetMapping("/")
    public ResponseEntity<List<MarketplaceDto>> getAllMarketplace () {
        List<MarketplaceDto> marketplaceDtoList = marketplaceMapper.convertMarketplaceListToMarketplaceDtoList(marketplaceService.findAllMarketplaces());

        if (marketplaceDtoList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(marketplaceDtoList);
        }
        return ResponseEntity.status(HttpStatus.OK).body(marketplaceDtoList);
    }

    @PostMapping("/list_product")
    public void addProductToMarketplace (@RequestBody Long productId) {
        MarketplaceDto marketplaceDto = marketplaceMapper.convertMarketplaceToMarketplaceDto(marketplaceService.saveProductToMarketplace(productId));
    }

    @GetMapping("/marketplace/test")
    public Integer getOne() {
        return 1;
    }

    @PostMapping("/order/{id}")
    public String addOrder (@PathVariable("id") String id) {
        Long productId = Long.parseLong(id);
        Marketplace marketplace = new Marketplace(productId);
        marketplaceService.createMarketplace(marketplace);
        return marketplaceMapper.convertMarketplaceToMarketplaceDto(marketplace).toString();
    }
}
