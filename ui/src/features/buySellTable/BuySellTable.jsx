import React, {useEffect, useState} from "react";
import styles from './BuySellTable.module.css';
import {loadRows, selectRows} from "./buySellTableSlice";
import {useDispatch, useSelector} from "react-redux";

export function BuySellTable(props) {
    const rows = useSelector(selectRows);
    const dispatch = useDispatch();

    useEffect( () => {
        dispatch(loadRows(props.type))
    }, [dispatch]);
    
    return (
        <table>
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
            <tbody>
            {rows.map((row, index) => {
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
        </table>
    );
}