import React, { Fragment } from 'react';
import { Route, Routes } from 'react-router-dom';
import './App.css';
import MainPage from './components/main-page/MainPage';
import BondPage from './components/bonds/bond-page/BondPage';
import NoMatch from './components/error/NoMatch';
import Menu from './components/menu/Menu';
import RegisterPage from './components/register/RegisterPage';
import MaturityBondsPage from './components/bonds/maturity-bonds-page/MaturityBondsPage';
import Footer from './components/footer/Footer';
import LoginPage from './components/login/LoginPage';

const App = () => {
  return (
    <Fragment>
      <div className='position-relative'>
        <Menu />

        <Routes>
          <Route path='/' element={<MainPage />} />
          <Route path='/register' element={<RegisterPage />} />
          <Route path='/login' element={<LoginPage />} />
          <Route path='/bond/:bondId' element={<BondPage />} />
          <Route path='/bondsAtMaturity' element={<MaturityBondsPage />} />
          <Route path='*' element={<NoMatch />} />
        </Routes>

        <Footer />
      </div>
    </Fragment>
  );
};

export default App;
