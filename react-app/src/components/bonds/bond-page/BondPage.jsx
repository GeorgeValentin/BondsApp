import { Fragment, useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { findBondOfUser } from '../../../services/BondServices';
import { MDBTable, MDBTableHead, MDBTableBody } from 'mdb-react-ui-kit';
import '../../../App.css';
import { parseDate } from '../bond-card/BondCard';
import Button from '@mui/material/Button';

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

  if (activeBond === null) {
    return <div>Loading...</div>;
  }

  return (
    <Fragment>
      <div className='bond-data-header'>Bond data</div>

      <MDBTable className='bond-page-table' hover>
        <MDBTableHead>
          <tr>
            <th scope='col'>Property</th>
            <th scope='col'>Value</th>
          </tr>
      </MDBTableHead>
      <MDBTableBody>
        <tr>
          <td>Bond Id</td>
          <td>{bondId}</td>
        </tr>
        <tr>
          <td>Client</td>
          <td>{activeBond.client.bondHolder}</td>
        </tr>
        <tr>
          <td>Issuer</td>
          <td>{activeBond.client.issuer.issuerName}</td>
        </tr>
        <tr>
          <td>Maturity date</td>
          
          <td>{parseDate(activeBond.bondMaturityDate)}</td>
        </tr>
        <tr>
          <td>Coupon percent</td>
          <td>{activeBond.couponPercent}</td>
        </tr>
        <tr>
          <td>CUSIP</td>
          <td>{activeBond.cusip}</td>
        </tr>
        <tr>
          <td>ISIN</td>
          <td>{activeBond.isin}</td>
        </tr>
          <tr>
          <td>Face value</td>
          <td>{activeBond.faceValue}</td>
        </tr>
          <tr>
          <td>Trade settlement date</td>
          <td>{activeBond.tradeSettlementDate}</td>
        </tr>
          <tr>
          <td>Redemption status</td>
          <td>{activeBond.redemptionStatus}</td>
        </tr>
        
      </MDBTableBody>
    </MDBTable>

    <Button className='bond-page-trigger-button'>
      Trigger for redemption
    </Button>


      {/* <div>{bondId}</div>
      {activeBond.client && <div>{activeBond.client.bondHolder}</div>}
      {activeBond.client.issuer && (
        <div>{activeBond.client.issuer.issuerName}</div>
      )}
      <div>{activeBond.couponPercent}</div>
      <div>{activeBond.cusip}</div>
      <div>{activeBond.isin}</div>
      <div>{activeBond.faceValue}</div>
      <div>{activeBond.tradeSettlementDate}</div>
      <div>{activeBond.redemptionStatus}</div> */}
    </Fragment>
  );
};

export default BondPage;
