import { IProductAttribute, NewProductAttribute } from './product-attribute.model';

export const sampleWithRequiredData: IProductAttribute = {
  id: 66308,
};

export const sampleWithPartialData: IProductAttribute = {
  id: 42101,
  productId: 13624,
};

export const sampleWithFullData: IProductAttribute = {
  id: 16300,
  productId: 5217,
  attributeName: 'Assistant Trafficway',
  attributeValue: 'Legacy innovative Shilling',
};

export const sampleWithNewData: NewProductAttribute = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
