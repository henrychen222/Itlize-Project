import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { MessageService } from 'src/app/services/message.service';
import { Categories, ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.sass']
})
export class SearchComponent implements OnInit {
  categoriesPair: Categories;
  searchForm: FormGroup;
  selectedCat = '';
  filteredOptions: Observable<string[]>;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private messageService: MessageService,
    private itemService: ItemService
  ) {
    this.searchForm = this.fb.group({
      category: [''],
      subCategory: ['']
    });
  }

  ngOnInit() {
    this.searchForm.controls.subCategory.disable();

    this.messageService.message.subscribe(msg => {
      const { category, subCategory } = msg;
      if (category) {
        this.searchForm.controls.category.setValue(category);
        this.searchForm.controls.subCategory.enable();
      }
      if (subCategory) {
        this.searchForm.controls.subCategory.setValue(subCategory);
      } else {
        this.searchForm.controls.subCategory.setValue('');
      }
    });

    this.itemService.loadCategories().subscribe(data => {
      this.categoriesPair = data;
      this.autoComplete();
      if (this.searchForm.controls.category.value) {
        if (!this.searchForm.controls.subCategory.value) {
          this.filteredOptions = of(
            this.categoriesPair[this.searchForm.controls.category.value]
          );
        }
      }
    });
  }

  autoComplete() {
    this.searchForm.valueChanges.subscribe(({ category, subCategory }) => {
      if (this.searchForm.controls.subCategory.disabled) {
        this.searchForm.controls.subCategory.enable();
        subCategory = '';
      }

      if (!category) {
        return;
      }

      if (this.selectedCat !== category) {
        this.selectedCat = category;
        this.searchForm.controls.subCategory.setValue('');
      } else {
        this.filteredOptions = of(this.categoriesPair[category]).pipe(
          map(subArray =>
            subArray.filter(value =>
              value.toLowerCase().includes(subCategory.toLowerCase())
            )
          )
        );
      }
    });
  }

  onSubmit() {
    const { category, subCategory } = this.searchForm.value;

    if (!category) {
      return;
    }

    if (!subCategory) {
      return this.router.navigate(['user', 'query', category]);
    }

    const subCategoryUpper = subCategory.toUpperCase();
    const allSubCats = this.categoriesPair[category];

    let filtered = allSubCats.filter(
      value => value.toUpperCase() === subCategoryUpper
    );
    if (filtered.length === 1) {
      return this.router.navigate(['user', 'query', category, subCategory]);
    } else {
      filtered = allSubCats.filter(value =>
        value.toUpperCase().includes(subCategoryUpper)
      );
      if (filtered.length) {
        this.searchForm.controls.subCategory.setValue(filtered[0]);
      } else {
        this.searchForm.controls.subCategory.setValue('');
      }
    }
  }
}
