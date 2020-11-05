import { configureStore } from '@reduxjs/toolkit';
import counterReducer from '../features/counter/counterSlice';
import buySellTableReducer from '../features/buySellTable/buySellTableSlice';

export default configureStore({
  reducer: {
    counter:  counterReducer,
    buySellTable: buySellTableReducer
  },
});
