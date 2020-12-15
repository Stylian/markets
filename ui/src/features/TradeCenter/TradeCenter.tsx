import React, {Component} from "react";
import styles from "./TradeCenter.module.css";
import {loadTradeCenter} from "./TradeCenterScript";
import {TradeTable} from "./TradeTable";
import {TradeCenterObj} from "./TradeCenterTypes";

type TradeCenterProps = {
    
}



interface TradeCenterState {
    isLoaded: boolean;
    tradeCenterObj: TradeCenterObj
}

export class TradeCenter extends Component<TradeCenterProps, TradeCenterState> {

    constructor(props: TradeCenterProps) {
        super(props);

        this.state = {
            isLoaded: false,
            tradeCenterObj:
                {"id":0,
                    "tradeTables":{
                        "TIMBER":{
                            "id":0,
                            "good":"TIMBER",
                            "buyingOffers":
                                [
                                    {"id":0,"type":"BUY","good":"TIMBER","client":{"id":0,"name":"Venice"},"price":28.3,"quantity":2000},
                                    {"id":0,"type":"BUY","good":"TIMBER","client":{"id":0,"name":"Tunis"},"price":27.5,"quantity":300},
                                    {"id":0,"type":"BUY","good":"TIMBER","client":{"id":0,"name":"Lisbon"},"price":23.0,"quantity":600},
                                    {"id":0,"type":"BUY","good":"TIMBER","client":{"id":0,"name":"Genoa"},"price":24.8,"quantity":400}
                                    ],
                            "sellingOffers":[]},
                        "SILK":{"id":0,"good":"SILK","buyingOffers":[],"sellingOffers":[]}}}
        }

    }

    componentDidMount() {
        loadTradeCenter(this);
    }
    
    render() {
        return this.state.isLoaded ? (
            <div>
                {Object.keys(this.state.tradeCenterObj.tradeTables).map((good: string) => {
                    return (
                        <div>
                            <TradeTable tradeTable={this.state.tradeCenterObj.tradeTables[good]}/>
                        </div>
                    )
                })}
            </div>
        ) : (null);
    }
}