import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnterPaymentDetailsComponent } from './enter-payment-details.component';

describe('EnterPaymentDetailsComponent', () => {
  let component: EnterPaymentDetailsComponent;
  let fixture: ComponentFixture<EnterPaymentDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EnterPaymentDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnterPaymentDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
