import { BaseModel } from './BaseModel';

export interface Categories extends BaseModel {
  category: string;
  subCategory: string;
  attributes: {
    [key: string]: string;
  };
}
