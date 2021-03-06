package gr.manolis.steli.markets.offer;

import gr.manolis.steli.markets.trade_client.TradeClient;
import gr.manolis.steli.markets.good.Good;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OfferTest {

    @Test
    public void testConstructor() {

        TradeClient venice = new TradeClient("Venice");
        
        Offer offer = new Offer(
                Good.TIMBER,
                venice,
                OfferType.BUY,
                28.3,
                2000);
        assertThat(offer).isNotNull();

        offer.setId(-1L);
        assertThat(offer).hasNoNullFieldsOrProperties();
    }
}
