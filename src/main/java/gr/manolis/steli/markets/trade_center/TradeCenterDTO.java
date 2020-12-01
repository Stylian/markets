package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.good.Good;
import gr.manolis.steli.markets.trade_table.TradeTableDTO;

import java.util.Map;

public class TradeCenterDTO {
    private long id;
    private Map<Good, TradeTableDTO> tradeTables;
}
