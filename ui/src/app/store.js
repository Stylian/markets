import { configureStore } from '@reduxjs/toolkit';
import tradeCenterReducer from '../features/TradeCenter/TradeCenterSlice';

export default configureStore({
  reducer: {
    tradeCenter: tradeCenterReducer
  },
});
