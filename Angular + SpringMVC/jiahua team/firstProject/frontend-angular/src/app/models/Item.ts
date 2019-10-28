import { BaseModel } from './BaseModel';

export interface Item extends BaseModel {
  category: string;
  subCategory: string;
  verified: Date;
  imgUrl: string;

  // Product Summary
  description: { [key: string]: string };
  type$: { [key: string]: string };
  technical_specifications$: { [key: string]: string };

  // Product Details
  series_information: string[];

  // Contact
  sales_representative: { [key: string]: string };
  manufacturer: { [key: string]: string };

  // Past Selections
  past_selections$: { [key: string]: string };
}
