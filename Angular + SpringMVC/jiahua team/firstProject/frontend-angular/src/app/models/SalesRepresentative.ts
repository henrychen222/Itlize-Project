import { BaseModel } from './BaseModel';

export interface SalesRepresentative extends BaseModel {
  name: string;
  phone: number;
  email: string;
  web: string;
}
