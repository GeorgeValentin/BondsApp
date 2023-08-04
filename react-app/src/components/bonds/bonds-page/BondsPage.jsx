import { Fragment, useEffect, useState } from 'react';
import { findActiveBonds } from '../../../services/BondServices';
import BondCard from '../bond-card/BondCard';

import './BondsPage.css';
import Menu from '../../menu/Menu';

const BondsPage = () => {
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

    // Call named function
    getActiveBonds();
  }, []);

  console.log(activeBonds);

  return (
    <Fragment>
      <Menu />
      <div className='card-list-container'>
        {activeBonds.map((bond, index) => (
          <BondCard key={index}>{bond.issuerName}</BondCard>
        ))}
      </div>
    </Fragment>
  );
};

export default BondsPage;
