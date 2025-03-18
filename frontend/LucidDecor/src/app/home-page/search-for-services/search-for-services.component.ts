import { Component, OnInit } from '@angular/core';
  import { FormsModule } from '@angular/forms';
  import { CurrencyPipe, NgForOf, NgIf, NgClass } from '@angular/common';

  interface Service {
    name: string;
    description: string;
    price: number;
    active?: boolean; // Add active property to toggle accordion
  }

  @Component({
    selector: 'app-search-for-services',
    standalone: true,
    imports: [FormsModule, CurrencyPipe, NgIf, NgForOf, NgClass],
    templateUrl: './search-for-services.component.html',
    styleUrls: ['./search-for-services.component.css']
  })
  export class SearchForServicesComponent implements OnInit {
    searchQuery: string = '';
    services: Service[] = [];
    filteredServices: Service[] = [];

    ngOnInit(): void {
      this.fetchServices();
    }

    fetchServices(): void {
      // Simulate fetching data from a service
      this.services = [
        { name: 'Service 1', description: 'Description for service 1', price: 100 },
        { name: 'Service 2', description: 'Description for service 2', price: 200 },
        { name: 'Service 3', description: 'Description for service 3', price: 300 }
      ];
      this.filteredServices = this.services;
    }

    onSearch(): void {
      this.filteredServices = this.services.filter(service =>
        service.name.toLowerCase().includes(this.searchQuery.toLowerCase())
      );
    }

    toggleAccordion(service: Service): void {
      service.active = !service.active;
    }
  }
