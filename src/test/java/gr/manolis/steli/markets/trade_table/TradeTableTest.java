package gr.manolis.steli.markets.trade_table;

import gr.manolis.steli.markets.DevelopmentException;
import gr.manolis.steli.markets.trade_center.TradeClient;
import gr.manolis.steli.markets.good.Good;
import gr.manolis.steli.markets.offer.Offer;
import gr.manolis.steli.markets.offer.OfferType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TradeTableTest {

    TradeClient marseille = new TradeClient("Marseille");

    TradeClient londonSilk = new TradeClient("London");

    Offer marseilleOffer = new Offer(
            Good.TIMBER,
            marseille,
            OfferType.BUY,
            27.6,
            1500);
    Offer londonSilkOffer = new Offer(
            Good.SILK,
            londonSilk,
            OfferType.BUY,
            27.6,
            1500);
 
    @Test
    public void testConstructor() {

        TradeTable timberTable = new TradeTable(Good.TIMBER);

        assertThat(timberTable).isNotNull();

        timberTable.setId(-1L);
        assertThat(timberTable).hasNoNullFieldsOrProperties();
    }
  
    @Test
    public void testAddOffer() {

        TradeTable timberTable = new TradeTable(Good.TIMBER);

        timberTable.addOffer(marseilleOffer);
        assertThat(timberTable.getBuyingOffers()).hasSize(1);

        assertThrows(DevelopmentException.class, () -> {
            timberTable.addOffer(londonSilkOffer);
        });

    }
}
