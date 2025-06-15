import { Component } from '@angular/core';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { BookingFlowService } from '../booking-flow.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  standalone: true,
  imports: [NgIf, FormsModule],
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {
  paymentStatus: 'success' | 'failure' | 'pending' | 'proceed' | null = null;
  cardNumber = '';
  cardName = '';
  expiry = '';
  cvv = '';
  saveCard = false;

  // Dummy data for customer and product details
  customer = {
    name: 'John Doe',
    email: 'john.doe@email.com',
  };
  service = {
    name: 'Sample Architectural Service',
    projectAddress: '123 Main Street, Springfield',
    bookingDate: '2025-06-15',
    estimatedCompletion: '2025-07-01',
  };
  offer = {
    code: 'LUCID10',
    description: 'Get 10% off with code LUCID10',
    details: 'Apply the code at checkout to avail the discount.'
  };

  constructor(private readonly router: Router, private bookingFlow: BookingFlowService) {}

  setPaymentStatus(status: 'success' | 'failure' | 'pending' |'proceed'): void {
    if (status === 'proceed') {
      this.router.navigate(['/view-booking-history']);
    }
    this.paymentStatus = status;
  }

  submitPayment() {
    if (this.cardNumber && this.cardName && this.expiry && this.cvv) {
      this.bookingFlow.paymentDetails = {
        cardNumber: this.cardNumber,
        cardName: this.cardName,
        expiry: this.expiry,
        cvv: this.cvv,
        saveCard: this.saveCard,
        customer: this.customer,
        service: this.service,
        offer: this.offer
      };
      this.router.navigate(['/view-booking-history']);
    }
  }
}
