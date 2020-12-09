import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route} from "react-router-dom";
import {TestPage} from "./features/TestPage/TestPage";

function App() {
  return (
      <BrowserRouter>
        {/*<Route exact path='/' component={TradeCenter}/>*/}
        <Route exact path='/test' component={TestPage}/>
      </BrowserRouter>

  );
}

export default App;
