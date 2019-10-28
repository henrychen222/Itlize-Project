import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-simple-table',
  templateUrl: './simple-table.component.html',
  styleUrls: ['./simple-table.component.sass']
})
export class SimpleTableComponent implements OnInit {
  @Input() data: any;
  @Input() header: string;

  constructor() {}

  ngOnInit() {}
}
