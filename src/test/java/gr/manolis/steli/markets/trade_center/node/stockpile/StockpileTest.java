package gr.manolis.steli.markets.trade_center.node.stockpile;

import gr.manolis.steli.markets.trade_center.good.Good;
import gr.manolis.steli.markets.trade_center.node.Node;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StockpileTest {


    @Test
    public void testConstructor() {
        Node venice = new Node("Venice");
        Stockpile stockpile = new Stockpile(venice, Good.SILK, 300.23);
        
        assertThat(stockpile).isNotNull();

        stockpile.setId(-1L);
        assertThat(stockpile).hasNoNullFieldsOrProperties();
        
    }
    
}
