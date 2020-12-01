package gr.manolis.steli.markets.offer;

import gr.manolis.steli.markets.good.Good;
import lombok.Data;

@Data
public class OfferDTO {
    
    private Long id;
    private OfferType type;
    private Good good;
    private TradeClientToOfferDTO client;
    private double price;
    private int quantity;

    @Data
    public static class TradeClientToOfferDTO {
        private long id;
        private String name;
    }
}
