package gr.manolis.steli.markets.offer;

import gr.manolis.steli.markets.trade_center.TradeClient;
import gr.manolis.steli.markets.good.Good;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OfferMapperTest {

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

        OfferDTO offerDTO = OfferMapper.INSTANCE.toDTO(offer);

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

        List<OfferDTO> offersDTO = OfferMapper.INSTANCE.toDTO(offers);

        OfferDTO offerDTO = offersDTO.get(0);
        
        assertThat(offerDTO).isNotNull();
        assertThat(offerDTO).hasNoNullFieldsOrProperties();
    }

}
