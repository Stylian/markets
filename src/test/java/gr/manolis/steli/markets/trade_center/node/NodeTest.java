package gr.manolis.steli.markets.trade_center.node;

import gr.manolis.steli.markets.trade_center.good.Good;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NodeTest {
    
    @Test
    public void testConstructor() {
        Node node = new Node("Venice");
        
        assertThat(node.getStockpiles()).isNotEmpty();
        assertThat(node.getStockpiles()).hasSize(Good.values().length);

        node.setId(-1L);
        assertThat(node).hasNoNullFieldsOrProperties();
    }
    
    @Test
    public void testGetStockpileByGood() {
        Node node = new Node("Venice");

        assertThat(node.getStockpileByGood(Good.SILK)).isNotNull();
    }
}
