import { hostNameUrl } from '../config/apiConfig';
import axios from 'axios';

export const findActiveBonds = (userId) => {
  const activeBonds = axios.get(`${hostNameUrl}/users/${userId}/activeBonds`);
  return activeBonds;
};

export const findBondOfUser = (userId, bondId) => {
  const activeBond = axios.get(
    `${hostNameUrl}/users/${userId}/bonds/${bondId}`
  );
  return activeBond;
};

export const findBondsOfABookOfAUser = (userId, bookName) => {
  const activeBond = axios.get(
    `${hostNameUrl}/users/${userId}/books/${bookName}/bonds`
  );
  return activeBond;
};

export const login = (reqBody) => {
  const activeBond = axios.post(`${hostNameUrl}/login`, reqBody);
  return activeBond;
};

export const register = (reqBody) => {
  const activeBond = axios.post(`${hostNameUrl}/register`, reqBody);
  return activeBond;
};

export const findMaturityBonds = (userId) => {
  const maturityBonds = axios.get(`${hostNameUrl}/users/${userId}/bonds/maturity`);
  return maturityBonds;
};
