import styles from "./TradeCenter.module.css";
import {TableHeaders} from "./TableHeaders";
import {TableRows} from "./TableRows";

export const TradeTable = (props: any) => {
    let tradeTable = props.tradeTable;
    return (
        <div>
            <div>{tradeTable.good}</div>
            <div className={styles.splitscreen}>
                <div className={styles.left}>
                    <table>
                        <TableHeaders type={'buy'}/>
                        <TableRows rows={props.tradeTable.buyingOffers}/>
                    </table>
                </div>

                <div className={styles.right}>
                    <table>
                        <TableHeaders type={'sell'}/>
                        <TableRows rows={props.tradeTable.sellingOffers}/>
                    </table>
                </div>
            </div>
        </div>
    );
}
