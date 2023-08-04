import React, { Fragment } from 'react';
import BondsPage from './components/bonds/bonds-page/BondsPage';
import { Route, Routes } from 'react-router-dom';

import './App.css';

const App = () => {
  return (
    <Fragment>
      <Routes>
        {/* <Route path='allheroes' element={<AllHeroes />} />
        <Route path='addhero' element={<HeroForm />} /> */}
        <Route path='/' element={<BondsPage />} />
      </Routes>
    </Fragment>
  );
};

export default App;
