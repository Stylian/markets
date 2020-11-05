import React, {useState} from "react";
import styles from './BuySellTable.module.css';
import {selectRows} from "./buySellTableSlice";
import {useDispatch, useSelector} from "react-redux";

export function BuySellTable() {
    const rows = useSelector(selectRows);
    // const dispatch = useDispatch();
    // const [incrementAmount, setIncrementAmount] = useState('2');
    
    return (
        <table>
            <tr>
                <th colspan={4}>Buying offers</th>
            </tr>
            <tr>
                <th>order</th>
                <th>buyer</th>
                <th>price</th>
                <th>quantity</th>
            </tr>
            {rows.map( (row, index) => {
                return (
                    <tr>
                        <td>{index+1}</td>
                        <td>{row.node}</td>
                        <td>{row.price}</td>
                        <td>{row.quantity}</td>
                    </tr>
                )
            })}
        </table>
    );
}