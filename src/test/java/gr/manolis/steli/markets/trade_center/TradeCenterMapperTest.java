package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.good.Good;
import gr.manolis.steli.markets.offer.Offer;
import gr.manolis.steli.markets.offer.OfferType;
import gr.manolis.steli.markets.trade_client.TradeClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TradeCenterMapperTest {

    @Autowired
    private TradeCenterMapper tradeCenterMapper;
    
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
        tradeCenter.setId(-1L);
        tradeCenter.addOffer(marseilleOffer);

        TradeCenterDTO tradeCenterDTO = tradeCenterMapper.toDTO(tradeCenter);

        assertThat(tradeCenterDTO).isNotNull();
        assertThat(tradeCenterDTO).hasNoNullFieldsOrProperties();
    }
}
