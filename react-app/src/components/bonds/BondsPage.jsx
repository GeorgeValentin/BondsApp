import { Fragment, useEffect, useState } from 'react';

const BondsPage = () => {
  const [bonds, setBonds] = useState([]);

  useEffect(() => {}, []);

  return (
    <Fragment>
      <h2>This is the Active Bonds Page where I will display all the bonds</h2>
    </Fragment>
  );
};

export default BondsPage;
