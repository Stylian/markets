package gr.manolis.steli.markets.trade_table;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TradeTableMapper {

    TradeTableMapper INSTANCE = Mappers.getMapper(TradeTableMapper.class);

    TradeTableDTO toDTO(TradeTable tradeTable);

}
