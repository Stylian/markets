package gr.manolis.steli.markets;

import lombok.Data;

@Data
public class StockStatistics {

    private double enterpriseToRevenue;
    private double enterpriseToEBITDA;
    
    private double profitMargin;

    private double trailingEPS;
    private double forwardEPS;
    
    private double priceToBook;
    private double bookValue;
    
    private double beta;

    private double peg;
    
    private double forwardPE;
}
