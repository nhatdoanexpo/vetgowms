import { IProduct, NewProduct } from './product.model';

export const sampleWithRequiredData: IProduct = {
  id: 77672,
};

export const sampleWithPartialData: IProduct = {
  id: 7747,
  categoryName: 'Programmable Networked deliver',
  allowsSale: false,
  description: 'mindshare Stravenue invoice',
  isActive: true,
};

export const sampleWithFullData: IProduct = {
  id: 62539,
  code: 'District',
  name: 'Garden Customer-focused Island',
  retailerId: 13074,
  categoryName: 'yellow silver',
  allowsSale: false,
  description: 'encompassing vertical policy',
  hasVariants: true,
  isActive: true,
};

export const sampleWithNewData: NewProduct = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
