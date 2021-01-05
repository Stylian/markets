package gr.manolis.steli.markets.trade_client;

import gr.manolis.steli.markets.stockpile.Stockpile;
import gr.manolis.steli.markets.good.Good;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class TradeClient {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    
    @ToString.Exclude
    @OneToMany
    private Map<Good, Stockpile> stockpiles;

    public TradeClient(String name) {
        this.name = name;

        stockpiles = new HashMap<>();
        for (Good good : Good.values()) {
            stockpiles.put(good, new Stockpile(this, good, 0));
        }
    }

    public TradeClient() { }

    public Stockpile getStockpileByGood(Good good) {
        return stockpiles.get(good);
    }
    
}
