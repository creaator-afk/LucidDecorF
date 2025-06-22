import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { CurrencyPipe, NgIf, NgForOf, CommonModule } from '@angular/common';

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
  clientName: string;
  clientEmail: string;
  projectAddress: string;
  instructions: string;
  breakdown?: {
    basePrice: number;
    taxes: number;
    total: number;
    paymentMethod: string;
    estimatedCompletion: string;
    contactNumber: string;
  };
}

@Component({
  selector: 'app-confirm-booking',
  templateUrl: './confirm-booking.component.html',
  standalone: true,
  imports: [
    CurrencyPipe,
    NgIf,
    NgForOf,
    CommonModule
  ],
  styleUrls: ['./confirm-booking.component.css']
})
export class ConfirmBookingComponent implements OnInit {
  bookingDetails: BookingDetails | undefined;

  constructor(private readonly router: Router, private readonly route: ActivatedRoute) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.fetchBookingDetails(id);
  }

  fetchBookingDetails(id: number): void {
    // Dummy response for development/testing with all required details
    this.bookingDetails = {
      serviceId: id,
      date: '2025-06-15',
      service: {
        id: id,
        image: 'assets/images/service1.jpg',
        name: 'Sample Architectural Service',
        description: 'A detailed description of the selected architectural service, including scope, deliverables, and timeline.',
        price: 250
      },
      clientName: 'John Doe',
      clientEmail: 'john.doe@email.com',
      projectAddress: '123 Main Street, Springfield',
      instructions: 'Please call before arrival and bring all necessary materials.',
      breakdown: {
        basePrice: 250,
        taxes: 45, // 18% of 250
        total: 295,
        paymentMethod: 'Credit Card',
        estimatedCompletion: '2025-07-01',
        contactNumber: '+1-555-123-4567'
      }
    };
    // Uncomment below for real backend integration
    // this.interiorDesignService.getServiceById(id).subscribe((data : any) =>{
    //   this.bookingDetails = data;
    // });
  }

  confirmBooking() {
    this.router.navigate(['/payment']);
  }
}
