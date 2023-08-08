import { Link, NavLink, useNavigate } from 'react-router-dom';
import Logo from '../../images/Bank.png';

import './Menu.css';
import { Fragment } from 'react';
import { getLoggedInStatusFromLocalStorage } from '../utils/helpers';

const Menu = () => {
  const navigate = useNavigate();

  const handleLogOut = () => {
    localStorage.clear();

    navigate('/');
  };

  return (
    <Fragment>
      <div className='d-flex gap-4 flex-row justify-content-between py-2 px-4 menu-container'>
        <NavLink
          to='/'
          className='logo-menu-container d-flex justify-content-center align-items-center gap-2 text-decoration-none'
        >
          <img className='menu-logo' src={Logo} alt='db-logo-img' />
          <div className='text-light fw-bold menu-btn'>Bondify</div>
        </NavLink>

        <div className='d-flex justify-content-end align-items-center gap-3'>
          {getLoggedInStatusFromLocalStorage() === true ? (
            <Fragment>
              <div className='text-light fw-bold fs-6 fst-italic'>
                Welcome, {localStorage.getItem('userEmail')}
              </div>

              <NavLink
                className='d-flex align-items-center btn btn-light border border-light border-3 fw-bold menu-btn'
                to='/bondsAtMaturity'
              >
                Bonds at Maturity
              </NavLink>
              <button
                className='d-flex align-items-center btn btn-light border border-light border-3 fw-bold menu-btn'
                onClick={handleLogOut}
              >
                Log out
              </button>
            </Fragment>
          ) : (
            <Fragment>
              <NavLink
                className='d-flex align-items-center btn btn-light border border-light border-3 fw-bold menu-btn'
                to='/register'
              >
                Register
              </NavLink>

              <NavLink
                className='d-flex align-items-center btn btn-light border border-light border-3 fw-bold menu-btn'
                to='/login'
              >
                Login
              </NavLink>
            </Fragment>
          )}
        </div>
      </div>
    </Fragment>
  );
};
export default Menu;
