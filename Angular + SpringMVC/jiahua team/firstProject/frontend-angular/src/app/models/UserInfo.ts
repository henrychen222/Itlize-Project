import { BaseModel } from './BaseModel';
import { UserLogin } from './userLogin';
import { Address } from './Address';

export interface UserInfo extends BaseModel {
  firstName?: string;
  lastName?: string;
  picturePath?: string;

  userLogin: UserLogin;
  address?: Address;
}
