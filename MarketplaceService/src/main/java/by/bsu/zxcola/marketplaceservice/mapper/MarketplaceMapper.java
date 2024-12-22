package by.bsu.zxcola.marketplaceservice.mapper;

import by.bsu.zxcola.marketplaceservice.dto.MarketplaceDto;
import by.bsu.zxcola.marketplaceservice.entity.Marketplace;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarketplaceMapper {
    @Autowired
    private ModelMapper modelMapper;

    public MarketplaceDto convertMarketplaceToMarketplaceDto (Marketplace marketplace) {
        MarketplaceDto marketplaceDto = modelMapper.map(marketplace, MarketplaceDto.class);

        return marketplaceDto;
    }

    public Marketplace convertMarketplaceDtoToMarketplace (MarketplaceDto marketplaceDto) {
        Marketplace marketplace = modelMapper.map(marketplaceDto, Marketplace.class);

        return marketplace;
    }

    public List<MarketplaceDto> convertMarketplaceListToMarketplaceDtoList (List<Marketplace> marketplaceList) {
        List<MarketplaceDto> marketplaceDtoList = new ArrayList<>();

        for (Marketplace marketplace : marketplaceList) {
            MarketplaceDto marketplaceDto = new MarketplaceDto();
            marketplaceDto.setId(marketplace.getId());
            marketplaceDto.setItemId(marketplace.getProductId());

            marketplaceDtoList.add(marketplaceDto);
        }

        return marketplaceDtoList;
    }
}