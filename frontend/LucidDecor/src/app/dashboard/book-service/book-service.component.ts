import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {CurrencyPipe, NgIf, NgForOf, CommonModule} from '@angular/common';
import { BookingFlowService } from '../booking-flow.service';

interface Service {
  image: string;
  id: number;
  name: string;
  description: string;
  price: number;
  originalPrice?: number;
  features?: string[];
  category?: string;
  tags?: string[];
  scope?: string;
  duration?: string;
  team?: string;
  clientType?: string;
  discount?: string;
  priceOptions?: string[];
}

@Component({
  selector: 'app-book-service',
  templateUrl: './book-service.component.html',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CurrencyPipe,
    NgIf,
    NgForOf,
    CommonModule,
    RouterLink
  ],
  styleUrls: ['./book-service.component.css']
})
export class BookServiceComponent implements OnInit {
  serviceId: number | undefined;
  services: Service[] = [
    {
      id: 1,
      name: 'Modular Kitchen Design',
      description: 'Transform your kitchen with modern modular designs, premium materials, and space-saving solutions.',
      image: 'assets/images/kitchen-design.jpg',
      price: 25000,
      originalPrice: 30000,
      features: ['3D Visualization', 'Custom Cabinets', 'Lighting Plan', 'Appliance Integration'],
      category: 'Interior Design',
      tags: ['Customizable', 'Popular'],
      scope: 'Kitchen, up to 150 sq.ft.',
      duration: '2 weeks',
      team: '1 Designer, 1 Carpenter',
      clientType: 'Residential',
      discount: 'MEMBER DISCOUNT',
      priceOptions: ['Basic: ₹25,000', 'Premium: ₹35,000', 'Luxury: ₹50,000']
    },
    {
      id: 2,
      name: 'Electrical Wiring Consultation',
      description: 'Professional electrical planning and wiring for safe and efficient power distribution.',
      image: 'assets/images/electrical-wiring.jpg',
      price: 12000,
      originalPrice: 15000,
      features: ['Load Calculation', 'Safety Compliance', 'Smart Home Integration'],
      category: 'Electric',
      tags: ['Certified', 'Safety'],
      scope: '2BHK Apartment',
      duration: '1 week',
      team: '1 Electrician, 1 Engineer',
      clientType: 'Residential/Commercial',
      discount: 'NEW CLIENT OFFER',
      priceOptions: ['Standard: ₹12,000', 'Advanced: ₹18,000']
    },
    {
      id: 3,
      name: 'Home Renovation Planning',
      description: 'Comprehensive planning for home renovation including structural, interior, and utility upgrades.',
      image: 'assets/images/renovation-planning.jpg',
      price: 40000,
      originalPrice: 45000,
      features: ['Site Survey', '3D Layouts', 'Material Selection'],
      category: 'Planning',
      tags: ['End-to-End', 'Expert Team'],
      scope: 'Full Home, up to 2000 sq.ft.',
      duration: '1 month',
      team: '1 Architect, 2 Designers',
      clientType: 'Residential',
      discount: 'SEASONAL DISCOUNT',
      priceOptions: ['Basic: ₹40,000', 'Complete: ₹60,000']
    }
  ];
  bookServiceForm: FormGroup;
  selectedService: any;
  viewPricesDropdown = false;

  constructor(
    private readonly router: Router,
    private readonly route: ActivatedRoute,
    private readonly fb: FormBuilder,
    private bookingFlow: BookingFlowService
  ) {
    this.bookServiceForm = this.fb.group({
      date: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.selectedService = this.bookingFlow.selectedService || this.services[0];
    if (!this.selectedService) {
      this.router.navigate(['/select-service']);
    }
  }

  onSubmit() {
    if (this.bookServiceForm.valid) {
      this.bookingFlow.bookingDetails = {
        ...this.bookServiceForm.value,
        service: this.selectedService
      };
      this.router.navigate(['/payment']);
    }
  }

  fetchFeaturedServices(): void {
    // Simulate fetching data from a service
    this.services = [
      {
        id: 1,
        name: 'Service 1',
        description: 'Description for service 1',
        price: 100,
        image: 'assets/images/service1.jpg'
      },
      {
        id: 2,
        name: 'Service 2',
        description: 'Description for service 2',
        price: 200,
        image: 'assets/images/service2.jpg'
      },
      {
        id: 3,
        name: 'Service 3',
        description: 'Description for service 3',
        price: 300,
        image: 'assets/images/service3.jpeg'
      },
    ];
  }

  confirmBooking(id: number) {
    this.router.navigate(['/confirm-booking', id]);
  }
}
