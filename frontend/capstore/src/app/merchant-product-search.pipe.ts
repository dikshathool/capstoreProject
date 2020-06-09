import { Pipe, PipeTransform } from '@angular/core';
import { Product } from './product';

@Pipe({
  name: 'merchantProductSearch'
})
export class MerchantProductSearchPipe implements PipeTransform {
  filterṀerchantProduct: Product[];

  transform(productList: Product[], searchText: string): Product[] {
    if (searchText === undefined) {
      return productList;
    } else {
      return productList.filter(product => {
        // tslint:disable-next-line: max-line-length
        return (product.email.toLowerCase().includes(searchText.toLowerCase()) || product.productCategory.toLowerCase().includes(searchText.toLowerCase()));

      });
    }
  }

}
