package gr.manolis.steli.markets.trade_center;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TradeCenterMapper {

    TradeCenterMapper INSTANCE = Mappers.getMapper(TradeCenterMapper.class);

    TradeCenterDTO toDTO(TradeCenter tradeCenter);
}
