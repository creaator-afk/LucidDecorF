import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {CurrencyPipe, NgIf} from '@angular/common';

interface Service {
  image: string;
  id: number;
  name: string;
  description: string;
  price: number;
}

@Component({
  selector: 'app-book-service',
  templateUrl: './book-service.component.html',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CurrencyPipe,
    NgIf
  ],
  styleUrls: ['./book-service.component.css']
})
export class BookServiceComponent implements OnInit {
  serviceId: number | undefined;
  services: Service[] = [];
  bookServiceForm: FormGroup;

  constructor(private readonly router: Router, private readonly route: ActivatedRoute, private readonly fb: FormBuilder) {
    this.bookServiceForm = this.fb.group({
      date: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.fetchFeaturedServices()
    this.serviceId = +this.route.snapshot.paramMap.get('id')!;
    this.services = this.services.filter(service => service.id === this.serviceId);
  }

  onSubmit() {
    if (this.bookServiceForm.valid) {
      const bookingDetails = {
        serviceId: this.serviceId,
        ...this.bookServiceForm.value,
      };
      console.log('Booking Details:', bookingDetails)
      // TODO: Handle booking logic and remove console log
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
