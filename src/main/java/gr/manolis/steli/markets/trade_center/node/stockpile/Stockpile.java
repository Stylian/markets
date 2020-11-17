package gr.manolis.steli.markets.trade_center.node.stockpile;

import gr.manolis.steli.markets.trade_center.good.Good;
import gr.manolis.steli.markets.trade_center.node.Node;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Stockpile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Node node;
    
    private Good good;
    
    private double amount;

    public Stockpile(Node node, Good good, double amount) {
        this.node = node;
        this.good = good;
        this.amount = amount;
    }
}
