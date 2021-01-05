package gr.manolis.steli.markets.trade_client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeClientRepository extends CrudRepository<TradeClient, Long> {
    
    List<TradeClient> findAll();
}
