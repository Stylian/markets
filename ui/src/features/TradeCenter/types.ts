
export type TradeCenterObj = {
    id: number;
    tradeTables: {
        [key: string]: TradeTableObj;
    };
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
    client: TradeClientObj;
    price: number;
    quantity: number;
}

export type TradeClientObj = {
    id: number;
    name: string;
}