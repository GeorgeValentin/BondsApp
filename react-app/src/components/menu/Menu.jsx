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

        <div className='d-flex justify-content-end gap-3'>
          <NavLink
            className='d-flex align-items-center btn btn-primary menu-btn'
            to='/bond'
          >
            Bond
          </NavLink>

          <NavLink
            className='d-flex align-items-center btn btn-primary menu-btn'
            to='/someOtherPage'
          >
            Some Other Page{' '}
          </NavLink>
        </div>
      </div>
    </Fragment>
  );
};
export default Menu;
