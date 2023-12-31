import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IProductAttribute, NewProductAttribute } from '../product-attribute.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IProductAttribute for edit and NewProductAttributeFormGroupInput for create.
 */
type ProductAttributeFormGroupInput = IProductAttribute | PartialWithRequiredKeyOf<NewProductAttribute>;

type ProductAttributeFormDefaults = Pick<NewProductAttribute, 'id'>;

type ProductAttributeFormGroupContent = {
  id: FormControl<IProductAttribute['id'] | NewProductAttribute['id']>;
  productId: FormControl<IProductAttribute['productId']>;
  attributeName: FormControl<IProductAttribute['attributeName']>;
  attributeValue: FormControl<IProductAttribute['attributeValue']>;
};

export type ProductAttributeFormGroup = FormGroup<ProductAttributeFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class ProductAttributeFormService {
  createProductAttributeFormGroup(productAttribute: ProductAttributeFormGroupInput = { id: null }): ProductAttributeFormGroup {
    const productAttributeRawValue = {
      ...this.getFormDefaults(),
      ...productAttribute,
    };
    return new FormGroup<ProductAttributeFormGroupContent>({
      id: new FormControl(
        { value: productAttributeRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        }
      ),
      productId: new FormControl(productAttributeRawValue.productId),
      attributeName: new FormControl(productAttributeRawValue.attributeName),
      attributeValue: new FormControl(productAttributeRawValue.attributeValue),
    });
  }

  getProductAttribute(form: ProductAttributeFormGroup): IProductAttribute | NewProductAttribute {
    return form.getRawValue() as IProductAttribute | NewProductAttribute;
  }

  resetForm(form: ProductAttributeFormGroup, productAttribute: ProductAttributeFormGroupInput): void {
    const productAttributeRawValue = { ...this.getFormDefaults(), ...productAttribute };
    form.reset(
      {
        ...productAttributeRawValue,
        id: { value: productAttributeRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */
    );
  }

  private getFormDefaults(): ProductAttributeFormDefaults {
    return {
      id: null,
    };
  }
}
