import { Fragment, useState, useEffect } from 'react';
import { findMaturityBonds } from '../../../services/BondServices';
import BondCard from '../bond-card/BondCard';
import '../../main-page/MainPage.css';
import '../../../App.css';

import './MaturityBondsPage.css';
import { getUserIdFromLocalStorage } from '../../utils/helpers';

const MaturityBondsPage = () => {
  const [maturityBonds, setMaturityBonds] = useState([]);

  useEffect(() => {
    const getMaturityBonds = async () => {
      try {
        const userId = getUserIdFromLocalStorage();
        const res = await findMaturityBonds(userId);

        setMaturityBonds(res.data);
      } catch (err) {
        console.log(`The error ${err} occured when fetching the bonds`);
      }
    };

    getMaturityBonds();
  }, []);

  if (maturityBonds === null) {
    return <div>Loading...</div>;
  }

  const currentDate = new Date();

  const pastMaturityBonds = maturityBonds.filter((bond) => {
    const maturityDate = new Date(bond.bondMaturityDate);
    return maturityDate < currentDate;
  });

  const presentMaturityBonds = maturityBonds.filter((bond) => {
    const maturityDate = new Date(bond.bondMaturityDate);
    return maturityDate >= currentDate && maturityDate <= currentDate;
  });

  const futureMaturityBonds = maturityBonds.filter((bond) => {
    const maturityDate = new Date(bond.bondMaturityDate);
    return maturityDate > currentDate;
  });

  return (
    <div>
      <div className='text-separator-past'>
        These bonds reached maturity in the last 5 days:
      </div>
      <Fragment>
        <div className='card-list-container'>
          {pastMaturityBonds.length > 0 ? (
            pastMaturityBonds.map((bond, index) => (
              <BondCard bondInfo={bond} key={index} />
            ))
          ) : (
            <div>No bonds maturity dates in the last 5 days..</div>
          )}
        </div>
      </Fragment>

      <div className='text-separator-present'>
        These bonds reach maturity today:
      </div>
      <Fragment>
        <div className='card-list-container'>
          {presentMaturityBonds.length > 0 ? (
            presentMaturityBonds.map((bond, index) => (
              <BondCard bondInfo={bond} key={index} />
            ))
          ) : (
            <p>No bonds with maturity dates today.</p>
          )}
        </div>
      </Fragment>

      <div className='text-separator-future'>
        These bonds reach maturity in the future:
      </div>
      <Fragment>
        <div className='card-list-container'>
          {futureMaturityBonds.length > 0 ? (
            futureMaturityBonds.map((bond, index) => (
              <BondCard bondInfo={bond} key={index} />
            ))
          ) : (
            <p>No bonds with maturity dates in the next 5 days.</p>
          )}
        </div>
      </Fragment>
    </div>
  );
};

export default MaturityBondsPage;
