package gr.manolis.steli.markets.trade_center;

import gr.manolis.steli.markets.good.Good;
import gr.manolis.steli.markets.offer.Offer;
import gr.manolis.steli.markets.offer.OfferType;
import gr.manolis.steli.markets.trade_client.TradeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trade_center")
public class TradeCenterController {

    @Autowired
    private TradeCenterMapper tradeCenterMapper;
    
//temp method
    @GetMapping("/")
    public TradeCenterDTO getTradeCenter() {


        TradeClient venice = new TradeClient("Venice");
        TradeClient tunis = new TradeClient("Tunis");
        TradeClient lisbon = new TradeClient("Lisbon");
        TradeClient genoa = new TradeClient("Genoa");


        Offer veniceOffer = new Offer(
                Good.TIMBER,
                venice,
                OfferType.BUY,
                28.3,
                2000);
        Offer tunisOffer = new Offer(
                Good.TIMBER,
                tunis,
                OfferType.BUY,
                27.5,
                300);
        Offer lisbonOffer = new Offer(
                Good.TIMBER,
                lisbon,
                OfferType.BUY,
                23,
                600);
        Offer genoaOffer = new Offer(
                Good.TIMBER,
                genoa,
                OfferType.BUY,
                24.8,
                400);

        TradeCenter tradeCenter = new TradeCenter();
        tradeCenter.addOffer(veniceOffer);
        tradeCenter.addOffer(tunisOffer);
        tradeCenter.addOffer(lisbonOffer);
        tradeCenter.addOffer(genoaOffer);
        
        http://localhost:8080/api/trade_center/
        // needs dto to avoid loops
        return tradeCenterMapper.toDTO(tradeCenter);
    }
    
    
    
}
