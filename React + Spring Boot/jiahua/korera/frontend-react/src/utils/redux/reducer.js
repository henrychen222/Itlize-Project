import { ActionTypes } from './actions';

const initial_state = {
  user: null,
  token: null,
  error: null
};

export const handleAuth = (state = initial_state, action) => {
  const { type, user, token, error } = action;
  switch (type) {
    case ActionTypes.INIT:
    case ActionTypes.LOGIN:
    case ActionTypes.REGISTER:
      return { ...state, user, token, error: null };
    case ActionTypes.LOGOUT:
      return { ...state, user: null, token: null, error: null };
    case ActionTypes.ERROR:
      return { ...state, user: null, token: null, error };
    case ActionTypes.CLEAR_ERROR:
      return { ...state, error: null };
    default:
      return state;
  }
};
