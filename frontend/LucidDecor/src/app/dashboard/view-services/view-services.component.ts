import { Component } from '@angular/core';
import { NgForOf } from '@angular/common';
import { Router } from '@angular/router';
import { BookingFlowService } from '../booking-flow.service';

@Component({
  selector: 'app-view-services',
  standalone: true,
  imports: [NgForOf],
  templateUrl: './view-services.component.html',
  styleUrl: './view-services.component.css'
})
export class ViewServicesComponent {
  services = [
    { id: 1, name: 'Interior Design', price: 100, description: 'Transform your space with our expert interior design services.' },
    { id: 2, name: 'Furniture Assembly', price: 50, description: 'Professional furniture assembly for your convenience.' },
    { id: 3, name: 'Home Painting', price: 200, description: 'Revitalize your home with our high-quality painting services.' }
  ];

  constructor(private bookingFlow: BookingFlowService, private router: Router) {}

  selectService(service: any) {
    this.bookingFlow.selectedService = service;
    this.router.navigate(['/book-service']);
  }
}
