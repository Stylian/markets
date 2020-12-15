
interface assic {
    [key: string]: TradeTableObj;
}

export type TradeCenterObj = {
    id: number;
    tradeTables: assic;
}

export type TradeTableObj = {
    id: number;
    good: string;
    buyingOffers: OfferObj[];
    sellingOffers: OfferObj[];
}

export type OfferObj = {
    id: number;
    type: string;
    good: string;
    client: {
        id: number;
        name: string;
    }
    price: number;
    quantity: number;
}
