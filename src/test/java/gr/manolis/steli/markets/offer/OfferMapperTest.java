package gr.manolis.steli.markets.offer;

import gr.manolis.steli.markets.good.Good;
import gr.manolis.steli.markets.trade_center.TradeClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OfferMapperTest {

    @Autowired
    private OfferMapper offerMapper;
    
    @Test
    public void shouldMapToDTO() {
        
        TradeClient tunis = new TradeClient("Tunis");
        tunis.setId(-1L);
        Offer offer = new Offer(
                Good.TIMBER,
                tunis,
                OfferType.BUY,
                27.5,
                300);
        offer.setId(-1L);

        OfferDTO offerDTO = offerMapper.toDTO(offer);

        assertThat(offerDTO).isNotNull();
        assertThat(offerDTO).hasNoNullFieldsOrProperties();
    }

    @Test
    public void shouldMapToDTOList() {
        
        TradeClient tunis = new TradeClient("Tunis");
        tunis.setId(-1L);
        Offer offer = new Offer(
                Good.TIMBER,
                tunis,
                OfferType.BUY,
                27.5,
                300);
        offer.setId(-1L);

        List<Offer> offers = new ArrayList<>();
        offers.add(offer);

        List<OfferDTO> offersDTO = offerMapper.toDTO(offers);

        OfferDTO offerDTO = offersDTO.get(0);
        
        assertThat(offerDTO).isNotNull();
        assertThat(offerDTO).hasNoNullFieldsOrProperties();
    }

}
