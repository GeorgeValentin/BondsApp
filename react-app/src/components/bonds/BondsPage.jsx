import { Fragment, useEffect, useState } from 'react';
import { findActiveBonds } from '../../services/BondServices';

const BondsPage = () => {
  const [bonds, setBonds] = useState([]);

  useEffect(() => {
    setBonds(findActiveBonds());
    console.log(bonds);
  }, []);

  return (
    <Fragment>
      <h2>This is the Active Bonds Page where I will display all the bonds</h2>
      {/* {bonds.map((bond) => (
        <div>{bond.issuerName}</div>
      ))} */}
    </Fragment>
  );
};

export default BondsPage;
