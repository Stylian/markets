import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
import axios from "axios";

export const loadTradeCenter = createAsyncThunk('/trade_center', () =>
    axios.get("/api/trade_center/",
        {
        })
        .then(response => response.data)
        .catch(error => error)
);

export const tradeCenterSlice = createSlice({
    name: 'tradeCenter',
    initialState: {
        trade_center_obj: null,
        isLoaded: false,
        activeTradeTable: null,
    },
    reducers: {
    },
    extraReducers: {
        [loadTradeCenter.pending]: (state, action) => {
            console.log("loadTradeCenter pending");

        },
        [loadTradeCenter.fulfilled]: (state, action) => {
            console.log("loadTradeCenter fulfilled");
            state.trade_center_obj = action.payload;
            state.isLoaded = true;
        },
    },
});

export default tradeCenterSlice.reducer;
