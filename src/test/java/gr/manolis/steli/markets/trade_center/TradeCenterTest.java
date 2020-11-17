package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.trade_center.good.Good;
import gr.manolis.steli.markets.trade_center.node.Node;
import gr.manolis.steli.markets.trade_center.offer.Offer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TradeCenterTest {

    Node venice = new Node("Venice");
    Node tunis = new Node("Tunis");
    Node lisbon = new Node("Lisbon");
    Node genoa = new Node("Genoa");
    Node marseille = new Node("Marseille");
    
    Node londonSilk = new Node("London");
    
    Offer veniceOffer = new Offer(
            Good.TIMBER,
            venice,
            28.3,
            2000);
    Offer tunisOffer = new Offer(
            Good.TIMBER,
            tunis,
            27.5,
            300);
    Offer lisbonOffer = new Offer(
            Good.TIMBER,
            lisbon,
            23,
            600);
    Offer genoaOffer = new Offer(
            Good.TIMBER,
            genoa,
            24.8,
            400);
    Offer marseilleOffer = new Offer(
            Good.TIMBER,
            marseille,
            27.6,
            1500);
    Offer londonSilkOffer = new Offer(
            Good.SILK,
            londonSilk,
            27.6,
            1500);
    
    @Test
    public void testAddingOffers() {
        TradeCenter tradeCenter = new TradeCenter();
        tradeCenter.addBuyingOffer(veniceOffer);
        tradeCenter.addBuyingOffer(tunisOffer);
        tradeCenter.addBuyingOffer(londonSilkOffer);
        tradeCenter.addBuyingOffer(lisbonOffer);
        tradeCenter.addBuyingOffer(genoaOffer);
        tradeCenter.addBuyingOffer(marseilleOffer);
        
        assertThat(tradeCenter).isNotNull();

        tradeCenter.setId(-1L);
        assertThat(tradeCenter).hasNoNullFieldsOrProperties();
        
        assertThat(tradeCenter.getBuyingOffers().get(Good.TIMBER).getOffers()).hasSize(5);
        assertThat(tradeCenter.getBuyingOffers().get(Good.SILK).getOffers()).hasSize(1);
    }
    
}
