import { BaseModel } from './BaseModel';

export interface Manufacturer extends BaseModel {
  name: string;
  department: string;
  phone: number;
  email: string;
  web: string;
}
