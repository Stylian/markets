import styles from "./TradeCenter.module.css";
import {OfferObj} from "./TradeCenterTypes";

export const TableRows = (props: any) => {
    let rows = props.rows;
    return (
        <tbody>
        {rows.map((row: OfferObj, index: number) => {
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
