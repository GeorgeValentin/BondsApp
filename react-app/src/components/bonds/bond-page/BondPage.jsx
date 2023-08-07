import { Fragment, useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { findBondOfUser } from '../../../services/BondServices';

const BondPage = () => {
  const { bondId } = useParams();
  const [activeBond, setActiveBond] = useState(null);

  useEffect(() => {
    const getActiveBond = async () => {
      try {
        const res = await findBondOfUser(1, bondId);
        setActiveBond(res.data);
      } catch (err) {
        console.log(`The error ${err} occured when fetching the bonds`);
      }
    };

    getActiveBond();
  }, [bondId]);
  console.log(activeBond);
  if (activeBond === null) {
    return <div>Loading...</div>;
  }

  return (
    <Fragment>
      <div>This is an individual bond's page</div>
      <div>{bondId}</div>
      {activeBond.client && <div>{activeBond.client.bondHolder}</div>}
      {activeBond.client.issuer && (
        <div>{activeBond.client.issuer.issuerName}</div>
      )}
      <div>{activeBond.couponPercent}</div>
      <div>{activeBond.cusip}</div>
      <div>{activeBond.isin}</div>
      <div>{activeBond.faceValue}</div>
      <div>{activeBond.tradeSettlementDate}</div>
      <div>{activeBond.redemptionStatus}</div>
      <div>{}</div>
      <div>{}</div>
      <div>{}</div>
    </Fragment>
  );
};

export default BondPage;
