export interface IProductAttribute {
  id: number;
  productId?: number | null;
  attributeName?: string | null;
  attributeValue?: string | null;
}

export type NewProductAttribute = Omit<IProductAttribute, 'id'> & { id: null };
