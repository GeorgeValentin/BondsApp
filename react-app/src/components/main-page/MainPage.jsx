import { Fragment, useEffect, useState } from 'react';
import { findActiveBonds } from '../../services/BondServices';
import BondCard from '../bonds/bond-card/BondCard';
import AccessRestrictedLogo from '../../images/AccessRestricted.png';

import './MainPage.css';
import { getUserIdFromLocalStorage } from '../utils/helpers';

const MainPage = () => {
  const [activeBonds, setActiveBonds] = useState([]);
  const [userId, setUserId] = useState(null);

  useEffect(() => {
    const getActiveBonds = async () => {
      try {
        const loggedInUserId = getUserIdFromLocalStorage();

        setUserId(loggedInUserId);

        if (userId !== null) {
          const res = await findActiveBonds(userId);
          setActiveBonds(res.data);
        }
      } catch (err) {
        console.log(`The error ${err} occured when fetching the bonds`);
      }
    };

    getActiveBonds();
  }, [userId]);

  return (
    <Fragment>
      <div className='card-list-container'>
        {activeBonds.length === 0 ? (
          <div className='d-flex justify-content-center align-items-center flex-column'>
            <img
              className='access-restricted-logo'
              src={AccessRestrictedLogo}
              alt='access-restricted-img'
            />
            <div className='text-center fw-bold fs-4'>Access Restricted!</div>
          </div>
        ) : (
          activeBonds.map((bond, index) => (
            <BondCard bondInfo={bond} key={index} />
          ))
        )}
      </div>
    </Fragment>
  );
};

export default MainPage;
