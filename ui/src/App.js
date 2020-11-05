import React from 'react';
import './App.css';
import {BuySellTable} from "./features/buySellTable/BuySellTable";

function App() {
  return (
    <div className="App">
      <div className="splitscreen">
        <div className="left">
          <BuySellTable type={"buy"} />
        </div>

        <div className="right">
          <BuySellTable type={"sell"} />
        </div>
      </div>

    </div>
  );
}

export default App;
