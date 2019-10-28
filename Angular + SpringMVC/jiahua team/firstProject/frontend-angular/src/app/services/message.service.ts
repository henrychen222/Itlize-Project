import { Injectable } from '@angular/core';
import { Subject, BehaviorSubject } from 'rxjs';

import { Item } from '../models/Item';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  public message = new Subject<any>();

  public compareItems = new BehaviorSubject<Item[]>(null);

  constructor() {}
}
