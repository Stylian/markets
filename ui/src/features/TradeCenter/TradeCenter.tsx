import React, {Component} from "react";
import styles from "./TradeCenter.module.css";
import {loadTradeCenter} from "./TradeCenterScript";
import {TradeTable} from "./TradeTable";
import {TradeCenterObj} from "./TradeCenterTypes";

type TradeCenterState = {
    isLoaded: boolean;
    tradeCenterObj: TradeCenterObj
}

export class TradeCenter extends Component<any, TradeCenterState> {

    constructor(props: any) {
        super(props);

        this.state = {
            isLoaded: false,
            tradeCenterObj:
                {
                    id:0,
                    tradeTables:{ }
                }
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