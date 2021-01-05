package gr.manolis.steli.markets;

import gr.manolis.steli.markets.good.Good;
import gr.manolis.steli.markets.offer.Offer;
import gr.manolis.steli.markets.offer.OfferType;
import gr.manolis.steli.markets.offer.OffersRepository;
import gr.manolis.steli.markets.trade_client.TradeClient;
import gr.manolis.steli.markets.trade_client.TradeClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class OffersGenerator {
    
    @Autowired
    public TradeClientRepository tradeClientRepository;
    
    @Autowired
    public OffersRepository offersRepository;

    private final Random random = new Random();
    
    private List<TradeClient> clients;
    private List<TradeClient> buyingClients;
    private List<TradeClient> sellingClients;
    
    public OffersGenerator() {
        clients = tradeClientRepository.findAll();

        if(clients.size() < 2) {
            return;
        }

        buyingClients = clients.subList(0, (clients.size()/2) - 1);
        sellingClients = clients.subList((clients.size()/2), clients.size() - 1);
    }
    
    public void createRandomOffer() {

        if(clients.size() < 2) {
            return;
        }

        if(random.nextBoolean()) {
            
            int count = 0;
            for(TradeClient client: buyingClients) {
                if(offersRepository.findAllByTradeClient(client).size() > 0) {
                    continue;
                }

                Offer offer = new Offer(
                        Good.TIMBER,
                        buyingClients.get(count++),
                        OfferType.BUY,
                        28.3,
                        2000);
            }
            
            
        }else {
            
        }
        
        
        
        
    }
}
