import React, { Fragment } from 'react';
import { Route, Routes } from 'react-router-dom';
import './App.css';
import MainPage from './components/main-page/MainPage';
import BondPage from './components/bonds/bond-page/BondPage';
import NoMatch from './components/error/NoMatch';
import Menu from './components/menu/Menu';
import RegisterPage from './components/register/RegistePage';

const App = () => {
  return (
    <Fragment>
      <Menu />
      <Routes>
        <Route path='/' element={<MainPage />} />
        <Route path='register' element={<RegisterPage />} />
        <Route path='/bond/:bondId' element={<BondPage />} />
        <Route path='*' element={<NoMatch />} />
      </Routes>
    </Fragment>
  );
};

export default App;
