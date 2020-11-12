import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from 'axios';


export const getTests = createAsyncThunk('/testPage/getTests', () =>
    axios.get("/test/",)
        .then(response => response.data)
        .catch(error => error)
);

export const postTest = createAsyncThunk('/testPage/addTest', () => 
    axios.post("/test/",
        {
        })
        .then(response => response.data)
        .catch(error => error)
);

export const testPageSlice = createSlice({
    name: 'testPage',
    initialState: {
        isLoaded: false,
        hasRun: 0,
        tests: [],
    },
    reducers: {
    },
    extraReducers: {
        [getTests.pending]: (state, action) => {
            console.log("pending");

        },
        [getTests.fulfilled]: (state, action) => {
            console.log("fulfilled");
            console.log(action.payload)
            state.tests = action.payload;
            state.isLoaded = true;
        },
        [postTest.pending]: (state, action) => {
            console.log("pending");

        },
        [postTest.fulfilled]: (state, action) => {
            console.log("fulfilled");
            console.log(action.payload)
            state.hasRun += 1;
        }
    }
});

export const selectIsLoaded = state => state.testPage.isLoaded;
export const selectRuns = state => state.testPage.hasRun;
export const selectTests = state => state.testPage.tests;


export default testPageSlice.reducer;
