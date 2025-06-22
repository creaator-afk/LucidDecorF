import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class BookingFlowService {
  selectedService: any = null;
  bookingDetails: any = null;
  paymentDetails: any = null;

  reset() {
    this.selectedService = null;
    this.bookingDetails = null;
    this.paymentDetails = null;
  }
}

