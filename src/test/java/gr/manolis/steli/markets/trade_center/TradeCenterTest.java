package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.good.Good;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TradeCenterTest {

    @Test
    public void testConstructor() {
        TradeCenter tradeCenter = new TradeCenter();
        
        assertThat(tradeCenter).isNotNull();

        tradeCenter.setId(-1L);
        assertThat(tradeCenter).hasNoNullFieldsOrProperties();
    }
    
    
    @Test
    public void testGetTradeTableForGood() {
        TradeCenter tradeCenter = new TradeCenter();
        
        assertThat(tradeCenter.getTradeTableForGood(Good.TIMBER)).isNotNull();
        assertThat(tradeCenter.getTradeTableForGood(Good.SILK)).isNotNull();
    }
    
}
