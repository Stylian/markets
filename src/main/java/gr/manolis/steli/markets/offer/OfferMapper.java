package gr.manolis.steli.markets.offer;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    List<OfferDTO> toDTO(List<Offer> offers);
    OfferDTO toDTO(Offer offer);

    @AfterMapping
    default void afterMapping(@MappingTarget OfferDTO offerDTO, Offer offer) {

        OfferDTO.TradeClientToOfferDTO tradeClientToOfferDTO =
                new OfferDTO.TradeClientToOfferDTO();
        tradeClientToOfferDTO.setId(offer.getTradeClient().getId());
        tradeClientToOfferDTO.setName(offer.getTradeClient().getName());

        offerDTO.setClient(tradeClientToOfferDTO);
    }
}
