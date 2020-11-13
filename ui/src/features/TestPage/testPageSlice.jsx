import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import axios from 'axios';


export const getTests = createAsyncThunk('/testPage/getTests', () =>
    axios.get("/tests/",)
        .then(response => response.data)
        .catch(error => error)
);

export const postTest = createAsyncThunk('/testPage/addTest', () => 
    axios.post("/tests/",
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
        something: null,
    },
    reducers: {
    },
    extraReducers: {
        [getTests.pending]: (state, action) => {
            console.log("getTests pending");

        },
        [getTests.fulfilled]: (state, action) => {
            console.log("getTests fulfilled");
            console.log(action.payload)
            state.tests = action.payload;
            state.isLoaded = true;
        },
        [postTest.pending]: (state, action) => {
            console.log("postTest pending");

        },
        [postTest.fulfilled]: (state, action) => {
            console.log("postTest fulfilled");
            console.log(action.payload)
            state.hasRun += 1;
        }
    }
});

export default testPageSlice.reducer;
