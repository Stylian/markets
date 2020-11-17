package gr.manolis.steli.markets.trade_center.offer;

import gr.manolis.steli.markets.trade_center.good.Good;
import gr.manolis.steli.markets.trade_center.node.Node;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OfferTest {
    
    Node venice = new Node("Venice");

    @Test
    public void testNodesConstructor() {
        Offer offer = new Offer(
                Good.TIMBER,
                venice,
                28.3,
                2000);
        assertThat(offer).isNotNull();

        offer.setId(-1L);
        assertThat(offer).hasNoNullFieldsOrProperties();
    }
    
    @Test
    public void testConstructor() {
        Offer offer = new Offer(
                venice.getStockpileByGood(Good.TIMBER),
                28.3,
                2000);
        assertThat(offer).isNotNull();

        offer.setId(-1L);
        assertThat(offer).hasNoNullFieldsOrProperties();
    }
}
