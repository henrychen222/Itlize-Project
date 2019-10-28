import React, { useState } from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import { Provider } from 'react-redux';

import './App.sass';
import Header from './Components/Header/Header';
import Sidebar from './Components/Sidebar/Sidebar';
import Routes from './Components/Routes/Routes';
import { store } from './utils/redux/store';
import { init } from './utils/redux/actions';

function App() {
  const [loading, setLoading] = useState(true);
  store.dispatch(init()).then(() => setLoading(false));

  return loading ? null : (
    <Provider store={store}>
      <Router>
        <div className="App">
          <Header />
          <div className="container">
            <Sidebar />
            <Routes />
          </div>
        </div>
      </Router>
    </Provider>
  );
}

export default App;
