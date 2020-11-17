package gr.manolis.steli.markets.trade_center.node;

import gr.manolis.steli.markets.trade_center.good.Good;
import gr.manolis.steli.markets.trade_center.node.stockpile.Stockpile;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ToString.Exclude
    @OneToMany( mappedBy = "stockpile")
    private Map<Good, Stockpile> stockpiles;

    public Node(String name) {
        this.name = name;

        stockpiles = new HashMap<>();
        for (Good good : Good.values()) {
            stockpiles.put(good, new Stockpile(this, good, 0));
        }
    }

    public Stockpile getStockpileByGood(Good good) {
        return stockpiles.get(good);
    }

}
