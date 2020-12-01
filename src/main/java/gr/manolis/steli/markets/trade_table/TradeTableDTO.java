package gr.manolis.steli.markets.trade_table;

import gr.manolis.steli.markets.good.Good;
import gr.manolis.steli.markets.offer.OfferDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TradeTableDTO {
    private long id;
    private Good good;
    private List<OfferDTO> buyingOffers =  new ArrayList<>();
    private List<OfferDTO> sellingOffers =  new ArrayList<>();
}
