
export const TableHeaders = (props: any) => {
    let type = props.type;
    return (
        <thead>
        <tr>
            <th colSpan={4}>{type === 'buy' ? 'Buying' : 'Selling'} offers</th>
        </tr>
        <tr>
            <th>order</th>
            <th>{type === 'buy' ? 'buyer' : 'seller'}</th>
            <th>price</th>
            <th>quantity</th>
        </tr>
        </thead>
    );
}