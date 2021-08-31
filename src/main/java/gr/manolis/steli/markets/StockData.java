package gr.manolis.steli.markets;

import lombok.Data;

@Data
public class StockData {
    
    private String name;
    private double price;
    private String currency;
    private String symbol;
    
}
