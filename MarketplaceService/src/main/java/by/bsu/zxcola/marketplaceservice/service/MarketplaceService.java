package by.bsu.zxcola.marketplaceservice.service;

import by.bsu.zxcola.marketplaceservice.entity.Marketplace;
import by.bsu.zxcola.marketplaceservice.repository.MarketplaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MarketplaceService {
    @Autowired
    private final MarketplaceRepository marketplaceRepository;

    public Optional<Marketplace> findById(Long id)  {
        Optional<Marketplace> marketplace = marketplaceRepository.findById(id);
        return marketplace;
    }

    public List<Marketplace> findAllMarketplaces() {
        return marketplaceRepository.findAll();
    }

    public Marketplace saveProductToMarketplace(Long productId) {
        Marketplace marketplace = new Marketplace(productId);
        return marketplaceRepository.save(marketplace);
    }

    public Marketplace createMarketplace(Marketplace marketplace) {
        return marketplaceRepository.save(marketplace);
    }

    public Marketplace orderProductFromMarketplace(Long id) {
        Marketplace marketplace = marketplaceRepository.findById(id).orElse(null);
        System.out.println(marketplace.toString());
        marketplaceRepository.save(marketplace);
        return marketplace;
    }
}
