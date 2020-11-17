package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.trade_center.good.Good;
import gr.manolis.steli.markets.trade_center.node.stockpile.Stockpile;
import gr.manolis.steli.markets.trade_center.offer.Offer;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class TradeCenter {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ToString.Exclude
    @OneToMany
    private Map<Good, OffersTable> buyingOffers;

    @ToString.Exclude
    @OneToMany
    private Map<Good, OffersTable> sellingOffers;

    public TradeCenter() {
        buyingOffers = new HashMap<>();
        sellingOffers = new HashMap<>();
        for (Good good : Good.values()) {
            buyingOffers.put(good, new OffersTable());
            sellingOffers.put(good, new OffersTable());
        }
    }

    public void addBuyingOffer(Offer offer) {
        buyingOffers.get(offer.getStockpile().getGood()).addOffer(offer);
    }

    public void addSellingOffer(Offer offer) {
        sellingOffers.get(offer.getStockpile().getGood()).addOffer(offer);
    }


}
