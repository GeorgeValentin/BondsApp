import { hostNameUrl } from '../config/api';
import axios from 'axios';

export const findActiveBonds = () => {
  const activeBonds = axios.get(`${hostNameUrl}/activeBonds`);
  return activeBonds;
};

export const findActiveBond = (bondId) => {
  const activeBond = axios.get(`${hostNameUrl}/bonds/${bondId}`);
  return activeBond;
};
