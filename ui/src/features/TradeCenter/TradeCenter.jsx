import React, {useEffect} from "react";
import styles from './TradeCenter.module.css';
import {useDispatch, useSelector} from "react-redux";
import {loadTradeCenter} from "./tradeCenterSlice";


const Tableheaders = (props) => {
    return (
        <thead>
        <tr>
            <th colSpan={4}>{props.type === 'buy' ? 'Buying' : 'Selling'} offers</th>
        </tr>
        <tr>
            <th>order</th>
            <th>{props.type === 'buy' ? 'buyer' : 'seller'}</th>
            <th>price</th>
            <th>quantity</th>
        </tr>
        </thead>
    );
}

const TableRows = (props) => {
    return (
        <tbody>
        {props.rows.map((row, index) => {
            return (
                <tr>
                    <td>{index + 1}</td>
                    <td>{row.client.name}</td>
                    <td>{row.price}</td>
                    <td>{row.quantity}</td>
                </tr>
            )
        })}
        </tbody>
    );
}

export function TradeCenter() {
    const dispatch = useDispatch();
    const isLoaded = useSelector(state => state.tradeCenter.isLoaded);
    const tradeCenter = useSelector(state => state.tradeCenter.trade_center_obj);

    useEffect( () => {
        dispatch(loadTradeCenter());
    }, [dispatch]);
    
    let timber = isLoaded? tradeCenter.tradeTables['TIMBER'] : null;
    
    return isLoaded ? (
        <div className={styles.splitscreen}>
            <div className={styles.left}>
                <table>
                    <Tableheaders type={'buy'} />
                    <TableRows rows={timber.buyingOffers} />
                </table>
            </div>

            <div className={styles.right}>
                <table>
                    <Tableheaders type={'sell'} />
                    <TableRows rows={timber.sellingOffers} />
                </table>
            </div>
        </div>
    ) : (null);
}