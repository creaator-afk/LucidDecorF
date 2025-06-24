import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookingFlowService } from '../../booking-flow.service';
import { NgIf, NgForOf } from '@angular/common';

@Component({
  selector: 'app-select-service',
  standalone: true,
  imports: [NgForOf, NgIf],
  templateUrl: './select-service.component.html',
  styleUrl: './select-service.component.css'
})
export class SelectServiceComponent {
  // Placeholder for backend request to fetch services
  // In production, replace this with a service call, e.g.:
  // this.serviceApi.getServices().subscribe(data => this.services = data);
  services = [
    { id: 1, name: 'Interior Design', price: 100 ,shortDescription: 'Professional interior design services for your home or office.', category: 'Design', duration: '2 hours'},
    { id: 2, name: 'Furniture Assembly', price: 50 , shortDescription: 'Expert furniture assembly services for all types of furniture.', category: 'Assembly', duration : '1 hour'},
    { id: 3, name: 'Home Painting', price: 200 , shortDescription: 'High-quality home painting services to refresh your space.', category: 'Painting', duration: '3 hours'},
  ];

  constructor(private bookingFlow: BookingFlowService, private router: Router) {}

  selectService(service: any) {
    // Placeholder for backend request to reserve or validate service
    // Example:
    // this.bookingApi.reserveService(service.id).subscribe(response => { ... });
    this.bookingFlow.selectedService = service;
    this.router.navigate(['/book-service']);
  }
}
