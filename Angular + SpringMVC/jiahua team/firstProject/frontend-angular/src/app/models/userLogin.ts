import { BaseModel } from './BaseModel';

export interface UserLogin extends BaseModel {
  email: string;
  username: string;
  password: string;
  salt?: string;
}
