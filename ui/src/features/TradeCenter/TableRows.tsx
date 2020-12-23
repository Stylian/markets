import {OfferObj} from "./types";

export const TableRows = (props: any) => {
    let rows = props.rows;
    return (
        <tbody>
        {rows.map((row: OfferObj, index: number) => {
            return (
                <tr key={index}>
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
