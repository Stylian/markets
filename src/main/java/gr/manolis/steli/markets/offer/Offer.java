package gr.manolis.steli.markets.offer;

import gr.manolis.steli.markets.trade_client.TradeClient;
import gr.manolis.steli.markets.good.Good;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private OfferType type;

    private Good good;
    
    @ManyToOne
    private TradeClient tradeClient;

    private double price;
    private int quantity;

    public Offer(Good good, TradeClient tradeClient, OfferType type, double price, int quantity) {
        this.good = good;
        this.tradeClient = tradeClient;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public Offer() {    }
}