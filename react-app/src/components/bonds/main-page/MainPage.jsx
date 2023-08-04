import { Fragment, useEffect, useState } from 'react';
import { findActiveBonds } from '../../../services/BondServices';
import BondCard from '../bond-card/BondCard';

import './MainPage.css';

const MainPage = () => {
  const [activeBonds, setActiveBonds] = useState([]);

  useEffect(() => {
    const getActiveBonds = async () => {
      try {
        const res = await findActiveBonds();
        setActiveBonds(res.data);
      } catch (err) {
        console.log(`The error ${err} occured when fetching the bonds`);
      }
    };

    getActiveBonds();
  }, []);

  return (
    <Fragment>
      <div className='card-list-container'>
        {activeBonds.map((bond, index) => (
          <BondCard bondInfo={bond} key={index}>
            {bond.issuerName}
          </BondCard>
        ))}
      </div>
    </Fragment>
  );
};

export default MainPage;
