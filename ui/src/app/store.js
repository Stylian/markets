import { configureStore } from '@reduxjs/toolkit';
import tradeCenterReducer from '../features/TradeCenter/tradeCenterSlice';
import testPageReducer from '../features/TestPage/testPageSlice';

export default configureStore({
  reducer: {
    tradeCenter: tradeCenterReducer,
    testPage: testPageReducer
  },
});
