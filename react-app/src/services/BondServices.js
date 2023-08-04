import { hostNameUrl } from '../config/api';
import axios from 'axios';

export const findActiveBonds = () => {
  const activeBonds = axios.get(`${hostNameUrl}/activeBonds`);
  return activeBonds;
};
