export const getUserIdFromLocalStorage = () => {
  return JSON.parse(localStorage.getItem('userId'));
};

export const getUserEmailFromLocalStorage = () => {
  return JSON.parse(localStorage.getItem('userEmail'));
};

export const getLoggedInStatusFromLocalStorage = () => {
  return JSON.parse(localStorage.getItem('loggedInStatus'));
};
