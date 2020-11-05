import { createSlice } from '@reduxjs/toolkit';

export const buySellTableSlice = createSlice({
    name: 'buySellTable',
    initialState: {
        value: 0,
        rows: [
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
        ]
    },
    // reducers: {
    //     increment: state => {
    //         // Redux Toolkit allows us to write "mutating" logic in reducers. It
    //         // doesn't actually mutate the state because it uses the Immer library,
    //         // which detects changes to a "draft state" and produces a brand new
    //         // immutable state based off those changes
    //         state.value += 1;
    //     },
    //     decrement: state => {
    //         state.value -= 1;
    //     },
    //     incrementByAmount: (state, action) => {
    //         state.value += action.payload;
    //     },
    // },
});

// export const { increment, decrement, incrementByAmount } = buySellTableSlice.actions;

export const selectRows = state => state.buySellTable.rows;

export default buySellTableSlice.reducer;
