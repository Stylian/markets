package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.DevelopmentException;
import gr.manolis.steli.markets.trade_center.good.Good;
import gr.manolis.steli.markets.trade_center.offer.Offer;
import gr.manolis.steli.markets.trade_center.offer.OfferType;
import lombok.Data;
import lombok.SneakyThrows;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class TradeTable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private Good good;
    
    @OneToMany
    private List<Offer> buyingOffers =  new ArrayList<>();

    @OneToMany
    private List<Offer> sellingOffers =  new ArrayList<>();
    
    public TradeTable(Good good) {
        this.good = good;
    }
    
    @SneakyThrows
    public void addOffer(Offer offer) {
        
        if(!offer.getGood().equals(good)) {
            throw new DevelopmentException("adding offer to the wrong trade table, different good");
        }
        
        if(offer.getType().equals(OfferType.BUY)) {
            buyingOffers.add(offer);
        }else if(offer.getType().equals(OfferType.SELL)) {
            sellingOffers.add(offer);
        }else{
            throw new DevelopmentException("offer type not set");
        }
    }
}
