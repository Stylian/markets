package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.good.Good;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TradeClientTest {

    @Test
    public void testConstructor() {

        TradeClient venice = new TradeClient("Venice");

        assertThat(venice.getStockpiles()).isNotEmpty();
        assertThat(venice.getStockpiles()).hasSize(Good.values().length);

        venice.setId(-1L);
        assertThat(venice).hasNoNullFieldsOrProperties();
    }

    @Test
    public void testGetStockpileByGood() {

        TradeClient venice = new TradeClient("Venice");

        assertThat(venice.getStockpileByGood(Good.SILK)).isNotNull();
    }
}
