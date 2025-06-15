import { Component, OnInit } from '@angular/core';
import {CurrencyPipe, DatePipe, NgForOf, NgIf} from '@angular/common';
import { BookingFlowService } from '../booking-flow.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-view-booking-history',
  templateUrl: './view-booking-history.component.html',
  standalone: true,
  imports: [
    NgForOf,
    CurrencyPipe,
    DatePipe,
    RouterModule,
    NgIf
  ],
  styleUrls: ['./view-booking-history.component.css']
})
export class ViewBookingHistoryComponent implements OnInit {
  bookings: any[] = [];

  constructor(private bookingFlow: BookingFlowService) {}

  ngOnInit() {
    // Dummy bookings for testing
    this.bookings = [
      {
        service: 'Interior Design Consultation',
        date: '2025-06-10',
        price: 150,
        cardName: 'John Doe'
      },
      {
        service: 'Home Painting',
        date: '2025-05-20',
        price: 300,
        cardName: 'Jane Smith'
      },
      {
        service: 'Furniture Assembly',
        date: '2025-04-15',
        price: 80,
        cardName: 'John Doe'
      }
    ];
    // If you want to show the latest booking from the flow, you can prepend it
    if (this.bookingFlow.bookingDetails && this.bookingFlow.paymentDetails) {
      this.bookings.unshift({
        service: this.bookingFlow.bookingDetails.service?.name,
        date: this.bookingFlow.bookingDetails.date,
        price: this.bookingFlow.bookingDetails.service?.price,
        cardName: this.bookingFlow.paymentDetails.cardName
      });
    }
  }
}
