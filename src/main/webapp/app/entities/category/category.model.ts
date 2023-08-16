import dayjs from 'dayjs/esm';

export interface ICategory {
  id: number;
  categoryId?: number | null;
  categoryName?: string | null;
  retailerId?: number | null;
  createdDate?: dayjs.Dayjs | null;
  parentId?: number | null;
}

export type NewCategory = Omit<ICategory, 'id'> & { id: null };
