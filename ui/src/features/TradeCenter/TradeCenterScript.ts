import {TradeCenter} from "./TradeCenter";

export const loadTradeCenter = (page: TradeCenter) => {
    fetch("/api/trade_center/")
        .then(res => res.json())
        .then(
            (result) => {
                page.setState(state => {
                    return {
                        ...state,
                        isLoaded: true,
                        tradeCenterObj: result,
                    }
                });
            },
            (error) => {
                page.setState(state => {
                    return {
                        ...state,
                        isLoaded: false,
                        error
                    }
                });
            }
        );
}
