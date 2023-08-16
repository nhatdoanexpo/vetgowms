import dayjs from 'dayjs/esm';

import { ICategory, NewCategory } from './category.model';

export const sampleWithRequiredData: ICategory = {
  id: 2529,
};

export const sampleWithPartialData: ICategory = {
  id: 30233,
  categoryId: 28254,
  categoryName: 'synthesizing Tala one-to-one',
  retailerId: 83759,
};

export const sampleWithFullData: ICategory = {
  id: 91149,
  categoryId: 97365,
  categoryName: 'transparent task-force Garden',
  retailerId: 39615,
  createdDate: dayjs('2023-08-16T04:26'),
  parentId: 54514,
};

export const sampleWithNewData: NewCategory = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
