import { hostNameUrl } from '../config/api';
import axios from 'axios';

export const findPets = () => {
  const pets = axios.get(`${hostNameUrl}/activeBonds`);
  return pets;
};
