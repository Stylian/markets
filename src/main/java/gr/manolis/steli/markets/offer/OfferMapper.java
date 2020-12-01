package gr.manolis.steli.markets.offer;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferMapper INSTANCE = Mappers.getMapper(OfferMapper.class);

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
