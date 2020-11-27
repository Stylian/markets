package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.trade_center.good.Good;
import gr.manolis.steli.markets.trade_center.offer.Offer;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
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
    private Map<Good, TradeTable> tradeTables;

    public TradeCenter() {
        tradeTables = new HashMap<>();
        for (Good good : Good.values()) {
            tradeTables.put(good, new TradeTable(good));
        }
    }

    public TradeTable getTradeTableForGood(Good good) {
        return tradeTables.get(good);
    }
    
    public void addOffer(Offer offer) {
        tradeTables.get(offer.getGood()).addOffer(offer);
    }
}
