import { Component } from '@angular/core';
import {ViewServicesComponent} from './view-services/view-services.component';
import {FilterServicesComponent} from './view-services/filter-services/filter-services.component';
import {SelectServiceComponent} from './view-services/select-service/select-service.component';
import {BookServiceComponent} from './book-service/book-service.component';
import {SelectDateTimeComponent} from './book-service/select-date-time/select-date-time.component';
import {ConfirmBookingComponent} from './book-service/confirm-booking/confirm-booking.component';
import {PaymentComponent} from './payment/payment.component';
import {EnterPaymentDetailsComponent} from './payment/enter-payment-details/enter-payment-details.component';
import {ReviewPaymentComponent} from './payment/review-payment/review-payment.component';
import {CompletePaymentComponent} from './payment/complete-payment/complete-payment.component';
import {ViewBookingHistoryComponent} from './view-booking-history/view-booking-history.component';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    ViewServicesComponent,
    FilterServicesComponent,
    SelectServiceComponent,
    BookServiceComponent,
    SelectDateTimeComponent,
    ConfirmBookingComponent,
    PaymentComponent,
    EnterPaymentDetailsComponent,
    ReviewPaymentComponent,
    CompletePaymentComponent,
    ViewBookingHistoryComponent,
    NgIf
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {
  selectedComponent: string = 'view-services';
  selectComponent(component: string) {
    this.selectedComponent = component;
  }
}
