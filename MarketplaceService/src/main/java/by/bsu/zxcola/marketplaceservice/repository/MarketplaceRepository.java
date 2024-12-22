package by.bsu.zxcola.marketplaceservice.repository;

import by.bsu.zxcola.marketplaceservice.entity.Marketplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketplaceRepository extends JpaRepository<Marketplace, Long> {

}
