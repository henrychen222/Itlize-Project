import {
  Component,
  OnInit,
  AfterViewInit,
  ViewChildren,
  QueryList,
  ElementRef
} from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Item } from 'src/app/models/Item';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.sass']
})
export class ItemComponent implements OnInit, AfterViewInit {
  item: Item;
  category: '';
  subCategory: '';
  loading = true;
  fields: { [key: string]: string | { min: string; max: string } };

  currentActive = 0;
  @ViewChildren('summary') summary: QueryList<ElementRef>;
  @ViewChildren('details') details: QueryList<ElementRef>;
  @ViewChildren('documentation') documentation: QueryList<ElementRef>;
  @ViewChildren('contact') contact: QueryList<ElementRef>;
  summaryOffsetTop = 0;
  detailsOffsetTop = 0;
  documentationOffsetTop = 0;
  contactOffsetTop = 0;

  constructor(
    private activatedRoute: ActivatedRoute,
    private itemService: ItemService
  ) {}

  ngOnInit() {
    const id = +this.activatedRoute.snapshot.params.id;
    this.initItem(id);
  }

  ngAfterViewInit() {
    this.summary.changes.subscribe(e => {
      this.summaryOffsetTop = e.first.nativeElement.offsetTop;

      this.details.changes.subscribe(e1 => {
        this.detailsOffsetTop = e1.first.nativeElement.offsetTop;
        this.detailsOffsetTop -= this.summaryOffsetTop;

        this.documentation.changes.subscribe(e2 => {
          this.documentationOffsetTop = e2.first.nativeElement.offsetTop;
          this.documentationOffsetTop -= this.summaryOffsetTop;

          this.contact.changes.subscribe(e3 => {
            this.contactOffsetTop = e3.first.nativeElement.offsetTop;
            this.contactOffsetTop -= this.summaryOffsetTop;
            this.summaryOffsetTop = 0;
          });
        });
      });
    });
  }

  initItem(id: number) {
    this.itemService.fetchItem(id).subscribe(i => {
      this.item = i;
      this.fields = this.techFields(i.technical_specifications$);
      this.loading = false;
    });
  }

  techFields = tech => {
    const field = {};
    for (const key in tech) {
      if (key.endsWith('$num')) {
        if (key.match(/\.(min)|(max)\$/)) {
          const name = key.substring(0, key.indexOf('.'));
          let extreme;
          if (key.includes('.min')) {
            extreme = 'min';
          } else {
            extreme = 'max';
          }
          if (!(name in field)) {
            field[name] = { [extreme]: tech[key] };
          } else {
            field[name][extreme] = tech[key];
          }
        } else {
          const name = key.substring(0, key.indexOf('$'));
          field[name] = tech[key];
        }
      }
    }
    return field;
  };

  scroll(el: HTMLElement) {
    el.scrollIntoView();
  }

  onScroll($event) {
    const { scrollTop } = $event.target;
    if (scrollTop < this.detailsOffsetTop) {
      this.currentActive = 1;
    } else if (scrollTop < this.documentationOffsetTop) {
      this.currentActive = 2;
    } else if (scrollTop < this.contactOffsetTop) {
      this.currentActive = 3;
    } else {
      this.currentActive = 4;
    }
  }
}
