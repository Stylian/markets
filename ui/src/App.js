import React from 'react';
import './App.css';
import {TradeCenter} from "./features/TradeCenter/TradeCenter";
import {TestPage} from "./features/TestPage/TestPage";
import {BrowserRouter, Route} from "react-router-dom";

function App() {
  return (
      <BrowserRouter>
          <Route exact path='/' component={TradeCenter}/>
          <Route exact path='/test' component={TestPage}/>
      </BrowserRouter>

  );
}

export default App;
