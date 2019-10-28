import { BaseModel } from './BaseModel';
import { SalesRepresentative } from './SalesRepresentative';
import { Manufacturer } from './Manufacturer';

export interface Product extends BaseModel {
  series: string;
  model: string;

  useType: string;
  application: string;
  mountingLocation: string;
  accessories: string;
  modelYear: number;

  category: string;
  subCategory: string;
  picturePath: string;

  verified: Date;
  details: string;

  data: {
    [key: string]: string;
  };
  dataInt: {
    [key: string]: number;
  };
  dataDouble: {
    [key: string]: number;
  };

  manufacturer: Manufacturer;
  salesRepresentative: SalesRepresentative;
}

export interface ProductProcessed extends BaseModel {
  series: string;
  model: string;

  useType: string;
  application: string;
  mountingLocation: string;
  accessories: string;
  modelYear: number;

  category: string;
  subCategory: string;
  picturePath: string;

  verified: Date;
  details: string;

  data: {
    [key: string]: any;
  };

  manufacturer: Manufacturer;
  salesRepresentative: SalesRepresentative;
}
