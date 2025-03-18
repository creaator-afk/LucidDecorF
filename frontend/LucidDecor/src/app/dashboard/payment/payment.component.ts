import { Component } from '@angular/core';
import {NgIf} from '@angular/common';
import {Router} from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  standalone: true,
  imports: [
    NgIf
  ],
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {
  paymentStatus: 'success' | 'failure' | 'pending' | 'proceed' | null = null;

  constructor(private readonly router: Router,) {
  }

  setPaymentStatus(status: 'success' | 'failure' | 'pending' |'proceed'): void {
    if (status === 'proceed') {
      this.router.navigate(['/view-booking-history']);
    }
    this.paymentStatus = status;
  }
}
