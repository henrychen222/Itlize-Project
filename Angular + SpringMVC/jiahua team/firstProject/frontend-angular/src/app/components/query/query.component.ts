import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of } from 'rxjs';

import { MessageService } from 'src/app/services/message.service';
import { ItemService, Filter } from 'src/app/services/item.service';
import { Item } from 'src/app/models/Item';

@Component({
  selector: 'app-query',
  templateUrl: './query.component.html',
  styleUrls: ['./query.component.sass']
})
export class QueryComponent implements OnInit {
  staticFilter: Filter;
  dynamicFilter: Observable<Filter>;
  category = '';
  subCategory = '';
  allItems: Item[];
  filteredItems: Observable<Item[]>;
  compareItems: Item[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private messageService: MessageService,
    private itemService: ItemService,
    private router: Router
  ) {}

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.category = params.category;
      this.subCategory = params.subCategory;
      this.messageService.message.next(params);
      this.initData(params);
    });
  }

  initData(params): void {
    this.itemService.fetchItems(params).subscribe(data => {
      this.staticFilter = data.filter;
      this.dynamicFilter = of(this.staticFilter);
      this.allItems = data.items;
      this.filteredItems = of(data.items);
    });
  }

  specificationsDescription(specifications, top = 4): string[] {
    let count = 0;
    const result = [];

    for (const key in specifications) {
      if (key.includes('$')) {
        const element = specifications[key];

        let unit = '';
        let reg = /\((.*)\)/;
        let matches = reg.exec(key);
        if (matches) {
          unit = matches[1];
        }

        let extreme = '';
        reg = /\.(.*)\$/;
        matches = reg.exec(key);
        if (matches) {
          extreme = matches[1];
        }

        let part = '';
        if (key.includes('(')) {
          part = key.substring(0, key.indexOf('('));
        } else if (key.includes('.')) {
          part = key.substring(0, key.indexOf('.'));
        } else {
          part = key.substring(0, key.indexOf('$'));
        }

        let description;
        if (extreme) {
          description = `${element} ${unit} at ${extreme} ${part.toLowerCase()}`;
        } else {
          description = `${element} ${unit} ${part.toLowerCase()}`;
        }
        result.push(description);

        count++;
        if (count >= top) {
          break;
        }
      }
    }
    return result;
  }

  handleChange() {
    const newItems = this.allItems.filter(item => {
      for (const key in this.staticFilter) {
        if (key.endsWith('$')) {
          const filterField = this.staticFilter[key];
          const itemField = item[key];
          for (const k in filterField) {
            if (k.match(/\$(type)|(Type)(TYPE)$/)) {
              if (
                filterField[k].selected &&
                filterField[k].selected !== itemField[k]
              ) {
                return false;
              }
            } else if (k.match(/\$(num)|(Num)|(NUM)$/)) {
              const [min, max] = filterField[k].range;
              const value = itemField[k];
              if (value < min || value > max) {
                return false;
              }
            }
          }
        }
      }
      return true;
    });
    this.filteredItems = of(newItems);
  }

  reset() {
    this.filteredItems = of(this.allItems);
    // tslint:disable-next-line: forin
    for (const key in this.staticFilter) {
      for (const k in this.staticFilter[key]) {
        if ('selected' in this.staticFilter[key][k]) {
          this.staticFilter[key][k].selected = '';
        } else {
          this.staticFilter[key][k].range = [
            this.staticFilter[key][k].min,
            this.staticFilter[key][k].max
          ];
        }
      }
    }
  }

  handleCompare(status, item) {
    if (status.checked) {
      this.compareItems.push(item);
    } else {
      this.compareItems = this.compareItems.filter(i => i !== item);
    }
  }

  toCompare() {
    this.messageService.compareItems.next(this.compareItems);
    this.router.navigate(['user', 'compare'], {
      queryParams: { category: this.category, subCategory: this.subCategory }
    });
  }
}
