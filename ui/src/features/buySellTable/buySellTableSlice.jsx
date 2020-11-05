import { createSlice } from '@reduxjs/toolkit';

export const buySellTableSlice = createSlice({
    name: 'buySellTable',
    initialState: {
        rows: []
    },
    reducers: {
        loadRows: (state, action) => {
            if(action.payload === 'buy') {
                state.rows = [
                    {
                        node: 'Venice',
                        price: 28,
                        quantity: 2000
                    },
                    {
                        node: 'Marseille',
                        price: 27,
                        quantity: 1500
                    },
                    {
                        node: 'Tunis',
                        price: 27,
                        quantity: 300
                    },
                    {
                        node: 'Genoa',
                        price: 25,
                        quantity: 400
                    },
                    {
                        node: 'Lisbon',
                        price: 23,
                        quantity: 600
                    },
                ];
            }
        },
    },
});

export const { loadRows } = buySellTableSlice.actions;

export const selectRows = state => state.buySellTable.rows;

export default buySellTableSlice.reducer;
