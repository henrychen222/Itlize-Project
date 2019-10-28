import { UserLogin } from './userLogin';

export interface UserLoginResponse {
  userLogin: UserLogin;
  token: string;
  expiration: string;
}
