import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CurrencyPipe, NgIf} from '@angular/common';

interface BookingDetails {
  serviceId: number;
  date: string;
  service: {
    id:number;
    image: string;
    name: string;
    description: string;
    price: number;
  };
}

@Component({
  selector: 'app-confirm-booking',
  templateUrl: './confirm-booking.component.html',
  standalone: true,
  imports: [
    CurrencyPipe,
    NgIf
  ],
  styleUrls: ['./confirm-booking.component.css']
})
export class ConfirmBookingComponent implements OnInit {
  bookingDetails: BookingDetails | undefined;

  constructor(private readonly router: Router,private readonly route: ActivatedRoute) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.fetchBookingDetails(id);
  }

  fetchBookingDetails(id: number): void {
    // Simulate fetching booking details from a service
    this.bookingDetails = {
      serviceId: id,
      date: '2023-12-01',
      service: {
        id: 1,
        name: 'Service 1',
        description: 'Description for service 1',
        price: 100,
        image: 'assets/images/service1.jpg'
      }
    };
  }

  confirmBooking() {
    this.router.navigate(['/payment']);
  }
}
