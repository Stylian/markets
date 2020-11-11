import {createSlice} from "@reduxjs/toolkit";

export const testPageSlice = createSlice({
    name: 'testPage',
    initialState: {
        hasRun: 0,
    },
    reducers: {
        addTest: state => {
            
            console.log("run post here");
            
            state.hasRun += 1;
        },
    },
});

export const { addTest } = testPageSlice.actions;

export const selectRuns = state => state.testPage.hasRun;

export default testPageSlice.reducer;
