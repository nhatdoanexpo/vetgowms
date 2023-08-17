export interface IProduct {
  id: number;
  code?: string | null;
  name?: string | null;
  retailerId?: number | null;
  categoryName?: string | null;
  allowsSale?: boolean | null;
  description?: string | null;
  hasVariants?: boolean | null;
  isActive?: boolean | null;
}

export type NewProduct = Omit<IProduct, 'id'> & { id: null };
