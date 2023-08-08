import * as React from 'react';
import { Fragment } from 'react';

import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { useNavigate } from 'react-router-dom';
import './BondCard.css';

export const parseDate = (dateAsString) => {
  const date = new Date(dateAsString);
  return `${date.toLocaleDateString()}`;
};

const BondCard = ({ bondInfo }) => {
  const { bondId, cusip, isin, issuerName, clientName, bondMaturityDate } =
    bondInfo;

  // console.log(bondId);
  const navigate = useNavigate();

  const handleNavigate = () => {
    navigate(`/bond/${bondId}`);
  };

  return (
    <Fragment>
      <Card className='card-container' sx={{ width: 350 }}>
        <CardMedia
          sx={{ marginX: 'auto' }}
          className='card-media-image'
          image={require('../../../images/BondAgreement.png')}
          title='Active Bond'
        />
        <CardContent id='bond-card-body'>
          <Typography
            sx={{ fontSize: 15 }}
            gutterBottom
            variant='h5'
            component='div'
            className='centered-text fw-bold'
            id='card-title'
          >
            {issuerName}
          </Typography>

          <div className='d-flex justify-content-between align-items-center flex-row centered-text lh-md'>
            <Typography className='fw-bold'>CLIENT</Typography>
            <Typography className='fst-italic'>{clientName}</Typography>
          </div>

          <div className='d-flex justify-content-between align-items-center flex-row centered-text lh-md'>
            <Typography className='fw-bold'>MATURITY</Typography>
            <Typography className='fst-italic'>
              {parseDate(bondMaturityDate)}
            </Typography>
          </div>

          <div className='d-flex justify-content-between align-items-center flex-row centered-text lh-md'>
            <Typography className='fw-bold'>CUSIP</Typography>
            <Typography className='fst-italic'>{cusip}</Typography>
          </div>

          <div className='d-flex justify-content-between align-items-center flex-row centered-text lh-md'>
            <Typography className='fw-bold'>ISIN</Typography>
            <Typography className='fst-italic'>{isin}</Typography>
          </div>
        </CardContent>
        <CardActions className='card-btns-container'>
          {/* <Button className='card-btn' size='small'>
            Other Stuff
          </Button> */}
          <Button className='card-btn' size='small' onClick={handleNavigate}>
            Learn More
          </Button>
        </CardActions>
      </Card>

    </Fragment>
    
  );
};

export default BondCard;
