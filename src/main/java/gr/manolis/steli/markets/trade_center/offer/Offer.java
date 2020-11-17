package gr.manolis.steli.markets.trade_center.offer;

import gr.manolis.steli.markets.trade_center.good.Good;
import gr.manolis.steli.markets.trade_center.node.Node;
import gr.manolis.steli.markets.trade_center.node.stockpile.Stockpile;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Stockpile stockpile;

    private double price;
    private int quantity;

    public Offer(Good good, Node node, double price, int quantity) {
        this(node.getStockpileByGood(good), price, quantity);
    }
    
    public Offer(Stockpile stockpile, double price, int quantity) {
        this.stockpile = stockpile;
        this.price = price;
        this.quantity = quantity;
    }

}