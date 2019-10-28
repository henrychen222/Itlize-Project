import axios from 'axios';

const apiUrl = process.env.REACT_APP_APIURL;

const LOGIN = 'LOGIN';
const REGISTER = 'REGISTER';
const INIT = 'INIT';
const LOGOUT = 'LOGOUT';
const ERROR = 'ERROR';
const CLEAR_ERROR = 'CLEAR_ERROR';
export const ActionTypes = {
  LOGIN,
  REGISTER,
  INIT,
  LOGOUT,
  ERROR,
  CLEAR_ERROR
};

export const login = user => dispatch => {
  axios
    .post(`${apiUrl}/auth/login`, user)
    .then(({ data: { userEntity, token } }) => {
      localStorage.setItem('token', token);
      dispatch({ type: LOGIN, user: userEntity, token });
    })
    .catch(({ data }) => {
      if (data) {
        const { message } = data;
        dispatch({ type: ERROR, error: { login: message } });
      } else {
        dispatch({
          type: ERROR,
          error: { login: 'Cannot connect to server' }
        });
      }
    });
};

export const loginTemp = user => dispatch => {
  axios
    .post(`${apiUrl}/auth/login`, user)
    .then(({ data: { userEntity, token } }) => {
      localStorage.removeItem('token');
      dispatch({ type: LOGIN, user: userEntity, token });
    })
    .catch(({ data }) => {
      if (data) {
        const { message } = data;
        dispatch({ type: ERROR, error: { login: message } });
      } else {
        dispatch({
          type: ERROR,
          error: { login: 'Cannot connect to server' }
        });
      }
    });
};

export const register = user => dispatch => {
  axios
    .post(`${apiUrl}/auth/register`, user)
    .then(({ data: { userEntity, token } }) => {
      localStorage.setItem('token', token);
      dispatch({ type: REGISTER, user: userEntity, token });
    })
    .catch(({ data }) => {
      if (data) {
        const { message } = data;
        dispatch({ type: ERROR, error: { register: message } });
      } else {
        dispatch({
          type: ERROR,
          error: { register: 'Cannot connect to server' }
        });
      }
    });
};

export const init = () => dispatch => {
  const token = localStorage.getItem('token');
  if (!token) {
    dispatch({ type: ERROR, error: { log: 'no local token' } });
    return Promise.resolve();
  }

  return axios
    .get(`${apiUrl}/auth/init`, {
      headers: { Authorization: 'Bearer ' + token }
    })
    .then(({ data }) => dispatch({ type: INIT, user: data, token }))
    .catch(({ data }) => {
      if (data) {
        const { message } = data;
        localStorage.removeItem('token');
        dispatch({ type: ERROR, error: { token: message } });
      }
    });
};

export const logout = () => {
  localStorage.removeItem('token');
  return {
    type: LOGOUT
  };
};

export const clearError = () => ({ type: CLEAR_ERROR });
