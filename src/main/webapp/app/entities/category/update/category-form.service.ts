import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import dayjs from 'dayjs/esm';
import { DATE_TIME_FORMAT } from 'app/config/input.constants';
import { ICategory, NewCategory } from '../category.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts ICategory for edit and NewCategoryFormGroupInput for create.
 */
type CategoryFormGroupInput = ICategory | PartialWithRequiredKeyOf<NewCategory>;

/**
 * Type that converts some properties for forms.
 */
type FormValueOf<T extends ICategory | NewCategory> = Omit<T, 'createdDate'> & {
  createdDate?: string | null;
};

type CategoryFormRawValue = FormValueOf<ICategory>;

type NewCategoryFormRawValue = FormValueOf<NewCategory>;

type CategoryFormDefaults = Pick<NewCategory, 'id' | 'createdDate'>;

type CategoryFormGroupContent = {
  id: FormControl<CategoryFormRawValue['id'] | NewCategory['id']>;
  categoryId: FormControl<CategoryFormRawValue['categoryId']>;
  categoryName: FormControl<CategoryFormRawValue['categoryName']>;
  retailerId: FormControl<CategoryFormRawValue['retailerId']>;
  createdDate: FormControl<CategoryFormRawValue['createdDate']>;
  parentId: FormControl<CategoryFormRawValue['parentId']>;
};

export type CategoryFormGroup = FormGroup<CategoryFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class CategoryFormService {
  createCategoryFormGroup(category: CategoryFormGroupInput = { id: null }): CategoryFormGroup {
    const categoryRawValue = this.convertCategoryToCategoryRawValue({
      ...this.getFormDefaults(),
      ...category,
    });
    return new FormGroup<CategoryFormGroupContent>({
      id: new FormControl(
        { value: categoryRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        }
      ),
      categoryId: new FormControl(categoryRawValue.categoryId),
      categoryName: new FormControl(categoryRawValue.categoryName),
      retailerId: new FormControl(categoryRawValue.retailerId),
      createdDate: new FormControl(categoryRawValue.createdDate),
      parentId: new FormControl(categoryRawValue.parentId),
    });
  }

  getCategory(form: CategoryFormGroup): ICategory | NewCategory {
    return this.convertCategoryRawValueToCategory(form.getRawValue() as CategoryFormRawValue | NewCategoryFormRawValue);
  }

  resetForm(form: CategoryFormGroup, category: CategoryFormGroupInput): void {
    const categoryRawValue = this.convertCategoryToCategoryRawValue({ ...this.getFormDefaults(), ...category });
    form.reset(
      {
        ...categoryRawValue,
        id: { value: categoryRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */
    );
  }

  private getFormDefaults(): CategoryFormDefaults {
    const currentTime = dayjs();

    return {
      id: null,
      createdDate: currentTime,
    };
  }

  private convertCategoryRawValueToCategory(rawCategory: CategoryFormRawValue | NewCategoryFormRawValue): ICategory | NewCategory {
    return {
      ...rawCategory,
      createdDate: dayjs(rawCategory.createdDate, DATE_TIME_FORMAT),
    };
  }

  private convertCategoryToCategoryRawValue(
    category: ICategory | (Partial<NewCategory> & CategoryFormDefaults)
  ): CategoryFormRawValue | PartialWithRequiredKeyOf<NewCategoryFormRawValue> {
    return {
      ...category,
      createdDate: category.createdDate ? category.createdDate.format(DATE_TIME_FORMAT) : undefined,
    };
  }
}
