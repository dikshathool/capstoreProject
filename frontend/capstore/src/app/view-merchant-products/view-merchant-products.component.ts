import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-products',
  templateUrl: './view-merchant-products.component.html',
  styleUrls: ['./view-merchant-products.component.css']
})
export class ViewMerchantProductsComponent implements OnInit {

  message = null;
  statusCode = null;

  products: any[];

  totalDiscount: any;

  constructor(public productService: ProductService) {
    this.productService.getMerchantProductList();
  }

  selectedProduct: Product = {
    productId: null,
    productName: null,
    productPrice: null,
    productQuantity: null,
    productCategory: null,
    productImage: null,
    productDiscount: null,
    productDiscountExpiryDate: null,
    productBrandName: null,
    email: null
  };

  updateProductDetails: Product = {
    productId: null,
    productName: null,
    productPrice: null,
    productQuantity: null,
    productCategory: null,
    productImage: null,
    productDiscount: null,
    productDiscountExpiryDate: null,
    productBrandName: null,
    email: null
  };

  selectProduct(product) {
    this.selectedProduct = product;
  }

  updateProductForm(updateProduct: NgForm) {
    this.updateProductDetails.productId = this.selectedProduct.productId;
    this.updateProductDetails.productName = updateProduct.value.productName;
    this.updateProductDetails.productPrice = updateProduct.value.productPrice;
    this.updateProductDetails.productQuantity = updateProduct.value.ProductQuantity;
    this.updateProductDetails.productCategory = updateProduct.value.productCategory;
    this.updateProductDetails.productImage = updateProduct.value.productImage;
    this.updateProductDetails.productDiscount = updateProduct.value.productDiscount;
    this.updateProductDetails.productDiscountExpiryDate = updateProduct.value.productDiscountExpiryDate;
    this.updateProductDetails.productBrandName = updateProduct.value.productBrandName;
    this.updateProductDetails.email = updateProduct.value.email;
    this.productService.updateProduct(this.updateProductDetails).subscribe(response => {
      console.log(response);
      updateProduct.reset();
    }, err => {
      console.log(err);
    });
  }

  deleteProduct(productId) {
    console.log(productId);
    this.productService.deleteProduct(productId).subscribe(response => {
      console.log(response.description);
      this.statusCode = response.statusCode;
      this.productService.getProductList();
      if (response.statusCode === 201) {
        this.message = response.description;
        alert(response.description);
      } else {
        this.message = response.description;
        alert(response.description);
      }
    });
  }

  // Method to calculate total discount price
  calculateDiscountPrice(price, discount) {
    console.log(discount);
    return price - (price * (discount / 100));
    console.log(this.totalDiscount);
  }

  ngOnInit() {
  }

}
