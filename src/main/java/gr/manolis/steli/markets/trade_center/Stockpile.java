package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.trade_center.good.Good;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Stockpile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private TradeClient tradeClient;

    private Good good;

    private double amount;

    public Stockpile(TradeClient tradeClient, Good good, double amount) {
        this.tradeClient = tradeClient;
        this.good = good;
        this.amount = amount;
    }
}
