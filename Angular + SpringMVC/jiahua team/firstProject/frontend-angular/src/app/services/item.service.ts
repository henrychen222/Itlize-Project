import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { of, Observable } from 'rxjs';
import { map, tap } from 'rxjs/operators';

import { environment } from 'src/environments/environment';
import { Item } from '../models/Item';

const { apiUrl } = environment;
type categoriesList = [string, string][];
export interface Categories {
  [key: string]: string[];
}
export interface Filter {
  [key$: string]: {
    [key$: string]: {
      selected?: string;
      choices?: string[];
      min?: number;
      max?: number;
      range?: [number, number];
    };
  };
}
export interface ItemsInfo {
  filter: Filter;
  items: Item[];
}
@Injectable({
  providedIn: 'root'
})
export class ItemService {
  cachedCategories: Categories = null;

  constructor(private http: HttpClient) {}

  fetchItem(id: number) {
    return this.http.get<Item>(`${apiUrl}/item/id/${id}`);
  }

  loadCategories(): Observable<Categories> {
    if (this.cachedCategories) {
      return of(this.cachedCategories);
    } else {
      return this.http.get<categoriesList>(`${apiUrl}/item/pair`).pipe(
        map(this.convertPair),
        tap(data => (this.cachedCategories = data))
      );
    }
  }

  convertPair(array: categoriesList): Categories {
    const result = {};
    array.forEach(([category, subCategory]) => {
      if (category in result) {
        result[category].push(subCategory);
      } else {
        result[category] = [subCategory];
      }
    });
    return result;
  }

  fetchItems(params): Observable<ItemsInfo> {
    const { category, subCategory } = params;

    if (subCategory) {
      return this.http
        .get<Item[]>(`${apiUrl}/item/subCategory/${subCategory}`)
        .pipe<ItemsInfo>(map<Item[], ItemsInfo>(this.processItems));
    }

    if (!category) {
      console.error(
        'Item service should not be triggered without category and subCategory'
      );
    }

    return this.http
      .get<Item[]>(`${apiUrl}/item/category/${category}`)
      .pipe<ItemsInfo>(map<Item[], ItemsInfo>(this.processItems));
  }

  processItems(items: Item[]): ItemsInfo {
    const filter = {};

    items.forEach((item: Item) => {
      for (const key in item) {
        if (key.endsWith('$')) {
          if (!(key in filter)) {
            filter[key] = {};
          }

          // tslint:disable-next-line: forin
          for (const filterKey in item[key]) {
            const [, type] = filterKey.split('$');
            if (type) {
              // this check could be unnecessary in fact, but just in case someone save data that's not well recognized by design
              if (type.toUpperCase() === 'TYPE') {
                if (!(filterKey in filter[key])) {
                  filter[key][filterKey] = { choices: new Set() };
                }
                filter[key][filterKey].choices.add(item[key][filterKey]);
              }

              if (type.toUpperCase() === 'NUM') {
                if (!(filterKey in filter[key])) {
                  filter[key][filterKey] = { min: null, max: null };
                }

                const value = +item[key][filterKey];
                item[key][filterKey] = value;

                if (
                  !filter[key][filterKey].min ||
                  filter[key][filterKey].min > value
                ) {
                  filter[key][filterKey].min = value;
                }

                if (
                  !filter[key][filterKey].max ||
                  filter[key][filterKey].max < value
                ) {
                  filter[key][filterKey].max = value;
                }
              }
            }
          }
        }
      }
    });

    // tslint:disable-next-line: forin
    for (const key in filter) {
      for (const k in filter[key]) {
        if (k.match(/\$(num|NUM|Num)$/)) {
          const [min, max] = [filter[key][k].min, filter[key][k].max];
          if (min === max) {
            delete filter[key][k];
          } else {
            filter[key][k].range = [filter[key][k].min, filter[key][k].max];
          }
        } else if (k.match(/\$(type|TYPE|Type)$/)) {
          if (filter[key][k].choices.size < 2) {
            delete filter[key][k];
          } else {
            filter[key][k].selected = '';
          }
        }
      }
    }

    return {
      filter,
      items
    };
  }
}
