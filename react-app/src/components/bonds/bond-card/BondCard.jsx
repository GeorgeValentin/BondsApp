import * as React from 'react';
import { Fragment } from 'react';

import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

import './BondCard.css';

const BondCard = ({ bondInfo }) => {
  const { cusip, isin, issuerName, clientName, bondMaturityDate } = bondInfo;

  return (
    <Fragment>
      <Card className='card-container' sx={{ width: 350 }}>
        <CardMedia
          sx={{ marginX: 'auto' }}
          className='card-media-image'
          image={require('../../../images/BondAgreement.png')}
          title='Active Bond'
        />
        <CardContent>
          <Typography
            sx={{ fontSize: 15 }}
            gutterBottom
            variant='h5'
            component='div'
            className='centered-text'
            id='card-title'
          >
            {issuerName}
          </Typography>
          <Typography
            variant='body2'
            color='text.secondary'
            className='centered-text'
          ></Typography>
        </CardContent>
        <CardActions className='card-btns-container'>
          <Button className='card-btn' size='small'>
            Other Stuff
          </Button>
          <Button className='card-btn' size='small'>
            Learn More
          </Button>
        </CardActions>
      </Card>
    </Fragment>
  );
};

export default BondCard;
