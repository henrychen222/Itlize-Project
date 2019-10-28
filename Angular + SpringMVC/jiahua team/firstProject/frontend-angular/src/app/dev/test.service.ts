import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from 'src/environments/environment';

const { apiUrl } = environment;

@Injectable({
  providedIn: 'root'
})
export class TestService {
  constructor(private http: HttpClient) {}

  getAddress() {
    return this.http.get(`${apiUrl}/address`);
  }

  getCategories() {
    return this.http.get(`${apiUrl}/categories`);
  }

  getProduct() {
    return this.http.get(`${apiUrl}/product`);
  }

  getUserLogin() {
    return this.http.get(`${apiUrl}/userLogin`);
  }
}
