package gr.manolis.steli.markets.offer;

import gr.manolis.steli.markets.trade_client.TradeClient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OffersRepository extends CrudRepository<Offer, Long> {
    
    List<Offer> findAllByTradeClient(TradeClient tradeClient);
}
