import { Component } from '@angular/core';
import {CurrencyPipe, NgForOf} from '@angular/common';

@Component({
  selector: 'app-view-booking-history',
  templateUrl: './view-booking-history.component.html',
  standalone: true,
  imports: [
    NgForOf,
    CurrencyPipe
  ],
  styleUrls: ['./view-booking-history.component.css']
})
export class ViewBookingHistoryComponent {
  bookings = [
    { id: 1, service: 'Residential Interior Design', date: '2023-12-01', price: 1000 },
    { id: 2, service: 'Commercial Interior Design', date: '2023-12-02', price: 2000 },
    { id: 3, service: 'Space Planning', date: '2023-12-03', price: 1500 },
    { id: 4, service: 'Furniture Selection and Arrangement', date: '2023-12-04', price: 800 },
    { id: 5, service: 'Lighting Design', date: '2023-12-05', price: 1200 },
    { id: 6, service: 'Color Consultation', date: '2023-12-06', price: 500 },
    { id: 7, service: 'Custom Furniture Design', date: '2023-12-07', price: 2500 },
    { id: 8, service: 'Window Treatments', date: '2023-12-08', price: 700 },
    { id: 9, service: 'Flooring Selection', date: '2023-12-09', price: 1800 },
    { id: 10, service: 'Home Staging', date: '2023-12-10', price: 900 }
  ];
}
