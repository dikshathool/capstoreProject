import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { ViewProductsComponent } from './view-products/view-products.component';
import {HttpClientModule} from '@angular/common/http';
import { AddProductComponent } from './add-product/add-product.component';
import { ViewMerchantProductsComponent } from './view-merchant-products/view-merchant-products.component';
import { MerchantProductSearchPipe } from './merchant-product-search.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    ViewProductsComponent,
    AddProductComponent,
    ViewMerchantProductsComponent,
    MerchantProductSearchPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
