import {Component, OnInit} from '@angular/core';
import {CurrencyPipe, NgClass, NgForOf, NgIf} from '@angular/common';
import {Router} from '@angular/router';

interface Service {
  image: string;
  id: number;
  name: string;
  description: string;
  price: number;
}

@Component({
  selector: 'app-view-featured-services',
  standalone: true,
  templateUrl: './view-featured-services.component.html',
  imports: [
    NgForOf,
    NgIf,
    CurrencyPipe,
    NgClass
  ],
  styleUrls: ['./view-featured-services.component.css']
})
export class ViewFeaturedServicesComponent implements OnInit {
  services: Service[] = [];

  constructor(private router: Router) {
  }

  ngOnInit(): void {
    this.fetchFeaturedServices();
  }

  bookService(service: number): void {
    this.router.navigate(['/book-service', service]);
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
}
