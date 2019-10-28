import { BaseModel } from './BaseModel';

export interface Address extends BaseModel {
  addrLine1?: string;
  addrLine2?: string;
  city?: string;
  zip?: number;
  state?: string;
}
