import { Link, NavLink } from 'react-router-dom';
import Logo from '../../images/Bank.png';

import './Menu.css';
import { Fragment } from 'react';

const Menu = () => {
  return (
    <Fragment>
      <div className='d-flex gap-4 flex-row justify-content-between py-2 px-4'>
        <Link to='/'>
          <img className='menu-logo' src={Logo} alt='db-logo-img' />
        </Link>

        <div className='d-flex justify-content-end gap-2'>
          <NavLink
            className='d-flex align-items-center btn btn-dark menu-btn border border-dark border-2 fw-bold'
            to='/register'
          >
            Register
          </NavLink>

          <NavLink
            className='d-flex align-items-center btn btn-outline-dark menu-btn border border-dark border-2 fw-bold'
            to='/login'
          >
            Login
          </NavLink>

          <NavLink
            className='d-flex align-items-center btn btn-outline-dark menu-btn border border-dark border-2 fw-bold'
            to='bondsAtMaturity'
          >
            Bonds maturity
          </NavLink>

        </div>
      </div>
    </Fragment>
  );
};
export default Menu;
