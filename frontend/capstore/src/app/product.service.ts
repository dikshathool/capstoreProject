import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  api = 'http://localhost:8080/';

  productId = null;

  productArray: [];

  constructor(private http: HttpClient, private router: Router) {
  }

  addProduct(data): Observable<any> {
    console.log(data);
    return this.http.post<any>(`${this.api}addProduct`, data);
  }

  getProductList() {
    this.http.get<any>(`${this.api}getProductList`).subscribe(data => {
      console.log(data.productList);
      this.productArray = data.productList;
    }, err => {
      console.log(err);
    });
  }

  getMerchantProductList() {
    this.http.get<any>(`${this.api}getMerchantProductList`).subscribe(data => {
      console.log(data.productList);
      this.productArray = data.productList;
    }, err => {
      console.log(err);
    });
  }

  updateProduct(data) {
    return this.http.post<any>(`${this.api}updateProduct`, data);
  }

  deleteProduct(productId) {
    return this.http.delete<any>(`${this.api}deleteProduct?productId=${productId}`);
  }

}
