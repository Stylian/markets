import { createSlice } from '@reduxjs/toolkit';

export const tradeCenterSlice = createSlice({
    name: 'tradeCenter',
    initialState: {
        buyingClients: [],
        sellingClients: [],
    },
    reducers: {
        loadBuyingClients: (state, action) => {
            state.buyingClients = [
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
        },
        loadSellingClients: (state, action) => {
            state.sellingClients = [
                {
                    node: 'Alexandria',
                    price: 24,
                    quantity: 800
                },
                {
                    node: 'Antioch',
                    price: 25,
                    quantity: 900
                },
                {
                    node: 'Crimea',
                    price: 29,
                    quantity: 400
                },
            ];
        },
    },
});

export const { loadBuyingClients, loadSellingClients } = tradeCenterSlice.actions;
export const selectBuyingClients = state => state.tradeCenter.buyingClients;
export const selectSellingClients = state => state.tradeCenter.sellingClients;

export default tradeCenterSlice.reducer;
