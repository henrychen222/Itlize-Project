import { createStore, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';

import { handleAuth } from './reducer';
import { refreshToken } from '../api/api';

export const store = createStore(
  handleAuth,
  applyMiddleware(thunk, refreshToken)
);
