import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, of } from 'rxjs';

import { MessageService } from 'src/app/services/message.service';
import { Item } from 'src/app/models/Item';

@Component({
  selector: 'app-compare',
  templateUrl: './compare.component.html',
  styleUrls: ['./compare.component.sass']
})
export class CompareComponent implements OnInit {
  category = '';
  subCategory = '';
  comparedItems: Observable<Item[]>;
  fields: { [key: string]: string | { min: string; max: string } };

  constructor(
    private activatedRoute: ActivatedRoute,
    private messageService: MessageService
  ) {}

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe(data => {
      const { category, subCategory } = data;
      this.category = category;
      this.subCategory = subCategory;
      this.messageService.message.next({ category, subCategory });
    });

    this.messageService.compareItems.subscribe((items: Item[]) => {
      this.fields = this.parseTechnicalSpecifications(items);
      this.comparedItems = of(items);
    });
  }

  // warning; all items must have exactly same format!
  parseTechnicalSpecifications = (
    items: Item[]
  ): { [key: string]: string | { min: string; max: string } } => {
    const fields = {};
    const example = items[0].technical_specifications$;

    for (const key in example) {
      if (key.endsWith('$num')) {
        if (key.match(/\.(max|min)\$num/)) {
          const name = key.substring(0, key.indexOf('.'));
          let extreme = '';
          if (key.includes('min')) {
            extreme = 'min';
          } else {
            extreme = 'max';
          }

          if (!(name in fields)) {
            fields[name] = { [extreme]: key };
          } else {
            fields[name][extreme] = key;
          }
        } else {
          const name = key.substring(0, key.indexOf('$'));
          fields[name] = key;
        }
      }
    }
    return fields;
  };
}
