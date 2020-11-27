package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.trade_center.good.Good;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StockpileTest {


    @Test
    public void testConstructor() {

        TradeClient venice = new TradeClient("Venice");
        Stockpile stockpile = new Stockpile(venice, Good.SILK, 300.23);

        assertThat(stockpile).isNotNull();

        stockpile.setId(-1L);
        assertThat(stockpile).hasNoNullFieldsOrProperties();

    }
    
}
