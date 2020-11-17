package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.trade_center.offer.Offer;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class OffersTable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @OneToMany
    private List<Offer> offers = new ArrayList<>();
    
    public void addOffer(Offer offer) {
        offers.add(offer);
    }
}
