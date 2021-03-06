package gr.manolis.steli.markets.trade_table;

import gr.manolis.steli.markets.trade_client.TradeClient;
import gr.manolis.steli.markets.good.Good;
import gr.manolis.steli.markets.offer.Offer;
import gr.manolis.steli.markets.offer.OfferType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TradeTableMapperTest {

    @Autowired
    private TradeTableMapper tradeTableMapper;
    
    @Test
    public void shouldMapToDTO() {
        
        TradeTable tradeTable = new TradeTable(Good.TIMBER);
        TradeClient marseille = new TradeClient("Marseille");
        marseille.setId(-1L);
        Offer marseilleOffer = new Offer(
                Good.TIMBER,
                marseille,
                OfferType.BUY,
                27.6,
                1500);
        marseilleOffer.setId(-1L);
        tradeTable.addOffer(marseilleOffer);
        tradeTable.setId(-1L);
        
        TradeTableDTO tradeTableDTO = tradeTableMapper.toDTO(tradeTable);

        assertThat(tradeTableDTO).isNotNull();
        assertThat(tradeTableDTO).hasNoNullFieldsOrProperties();
    }

}
