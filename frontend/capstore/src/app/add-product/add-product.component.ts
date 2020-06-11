import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  // dateObject = new Date();
  // date = this.dateObject.getDate();
  // month = this.dateObject.getMonth();
  // year = this.dateObject.getFullYear();

  // todaysDate = `${this.year}-${this.month + 1}-${this.date}`;

 message = null;

  constructor(private productService: ProductService) { }

  product(addProduct: NgForm) {
    this.productService.addProduct(addProduct.value).subscribe(response => {
      addProduct.reset();
      this.message = response.description;
      if (response.statusCode === 201) {
        alert(response.description);
      } else {
        alert(response.description);
      }
    });
  }

  ngOnInit() {
  }

}
