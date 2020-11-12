import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";


export const postTest = createAsyncThunk('/testPage/addTest', async () => {
    return fetch("/test/",
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            // body: this.props.match.params.seasonNum 
        })
        .then(res => res.json())
        .then(
            (result) => {
                // state.hasRun += 1;
            },
            (error) => {
            }
        )
})

export const testPageSlice = createSlice({
    name: 'testPage',
    initialState: {
        hasRun: 0,
    },
    reducers: {
    },
    extraReducers: {
        [postTest.pending]: (state, action) => {
            console.log("pending");
        },
        [postTest.fulfilled]: (state, action) => {
            console.log("fulfilled");
        }
    }
});

export const selectRuns = state => state.testPage.hasRun;

export default testPageSlice.reducer;
