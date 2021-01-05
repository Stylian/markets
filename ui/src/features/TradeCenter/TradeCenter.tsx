import React, {Component} from "react";
import {loadTradeCenter} from "./scripts";
import {TradeTable} from "./TradeTable";
import {TradeCenterObj} from "./types";
import {Tab, Tabs} from "react-bootstrap";

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
            <Tabs defaultActiveKey={Object.keys(this.state.tradeCenterObj.tradeTables)[0]}>
                {Object.keys(this.state.tradeCenterObj.tradeTables).map((good: string) => {
                    return (
                        <Tab eventKey={good} key={good} title={good}>
                            <TradeTable tradeTable={this.state.tradeCenterObj.tradeTables[good]}/>
                        </Tab>
                    )
                })}
            </Tabs>
        ) : (null);
    }
}