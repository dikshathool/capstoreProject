import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMerchantProductsComponent } from './view-merchant-products.component';

describe('ViewMerchantProductsComponent', () => {
  let component: ViewMerchantProductsComponent;
  let fixture: ComponentFixture<ViewMerchantProductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewMerchantProductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewMerchantProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
