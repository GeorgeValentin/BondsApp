import React, { Fragment } from 'react';
import { NavLink, Route, Routes } from 'react-router-dom';
import './App.css';
import MainPage from './components/bonds/main-page/MainPage';
import BondPage from './components/bonds/bond-page/BondPage';
import SomeOtherPage from './components/bonds/some-other-page/SomeOtherPage';
import NoMatch from './components/error/NoMatch';
import Menu from './components/menu/Menu';

const App = () => {
  return (
    <Fragment>
      <Menu />
      <Routes>
        <Route path='/' element={<MainPage />} />
        <Route path='bond' element={<BondPage />} />
        <Route path='someOtherPage' element={<SomeOtherPage />} />
        <Route path='*' element={<NoMatch />} />
      </Routes>
    </Fragment>
  );
};

export default App;
