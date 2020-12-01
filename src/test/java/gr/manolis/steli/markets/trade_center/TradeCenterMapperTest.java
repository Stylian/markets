package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.good.Good;
import gr.manolis.steli.markets.offer.Offer;
import gr.manolis.steli.markets.offer.OfferType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TradeCenterMapperTest {

    @Test
    public void shouldMapToDTO() {

        TradeClient marseille = new TradeClient("Marseille");
        marseille.setId(-1L);
        Offer marseilleOffer = new Offer(
                Good.TIMBER,
                marseille,
                OfferType.BUY,
                27.6,
                1500);
        marseilleOffer.setId(-1L);
        
        TradeCenter tradeCenter = new TradeCenter();
        tradeCenter.addOffer(marseilleOffer);

        TradeCenterDTO tradeCenterDTO = TradeCenterMapper.INSTANCE.toDTO(tradeCenter);

        assertThat(tradeCenterDTO).isNotNull();
        assertThat(tradeCenterDTO).hasNoNullFieldsOrProperties();
    }
}
