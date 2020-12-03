package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.trade_table.TradeTableMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TradeTableMapper.class)
public interface TradeCenterMapper {

    TradeCenterDTO toDTO(TradeCenter tradeCenter);
}
