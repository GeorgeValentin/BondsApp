import { hostNameUrl } from '../config/apiConfig';
import axios from 'axios';

export const findActiveBonds = async (userId) => {
  const activeBonds = await axios.get(
    `${hostNameUrl}/users/${userId}/activeBonds`
  );
  return activeBonds;
};

export const findBondOfUser = async (userId, bondId) => {
  const activeBond = await axios.get(
    `${hostNameUrl}/users/${userId}/bonds/${bondId}`
  );
  return activeBond;
};

export const findBondsOfABookOfAUser = async (userId, bookName) => {
  const activeBond = await axios.get(
    `${hostNameUrl}/users/${userId}/books/${bookName}/bonds`
  );
  return activeBond;
};

export const login = async (reqBody) => {
  // console.log(reqBody);
  const activeBond = await axios.post(`${hostNameUrl}/login`, reqBody);
  return activeBond;
};

export const register = async (reqBody) => {
  const activeBond = await axios.post(`${hostNameUrl}/register`, reqBody);
  return activeBond;
};
