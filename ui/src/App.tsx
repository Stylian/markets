import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route} from "react-router-dom";
import {TestPage} from "./features/TestPage/TestPage";
import {TradeCenter} from "./features/TradeCenter/TradeCenter";

function App() {
  return (
      <BrowserRouter>
        <Route exact path='/trade_center' component={TradeCenter}/>
        <Route exact path='/test' component={TestPage}/>
      </BrowserRouter>

  );
}

export default App;
