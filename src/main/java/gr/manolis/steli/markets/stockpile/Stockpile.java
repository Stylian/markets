package gr.manolis.steli.markets.stockpile;

import gr.manolis.steli.markets.good.Good;
import gr.manolis.steli.markets.trade_client.TradeClient;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Stockpile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

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
