package gr.manolis.steli.markets.trade_table;

import gr.manolis.steli.markets.offer.OfferMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = OfferMapper.class)
public interface TradeTableMapper {

    TradeTableDTO toDTO(TradeTable tradeTable);

}
