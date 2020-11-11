import React, {useEffect} from "react";
import styles from './TradeCenter.module.css';
import {
    loadBuyingClients,
    selectBuyingClients,
    loadSellingClients,
    selectSellingClients
} from "./tradeCenterSlice";
import {useDispatch, useSelector} from "react-redux";


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
                    <td>{row.node}</td>
                    <td>{row.price}</td>
                    <td>{row.quantity}</td>
                </tr>
            )
        })}
        </tbody>
    );
}

export function TradeCenter() {
    const buyingClients = useSelector(selectBuyingClients);
    const sellingClients = useSelector(selectSellingClients);
    const dispatch = useDispatch();

    useEffect( () => {
        dispatch(loadBuyingClients())
        dispatch(loadSellingClients())
    }, [dispatch]);
    
    return (
        <div className={styles.splitscreen}>
            <div className={styles.left}>
                <table>
                    <Tableheaders type={'buy'} />
                    <TableRows rows={buyingClients} />
                </table>
            </div>

            <div className={styles.right}>
                <table>
                    <Tableheaders type={'sell'} />
                    <TableRows rows={sellingClients} />
                </table>
            </div>
        </div>
    );
}