// src/app/home-page/search-for-services/search-for-services.component.ts
  import { Component, OnInit } from '@angular/core';
  import { FormsModule } from '@angular/forms';
  import { CurrencyPipe, NgForOf, NgIf, NgClass } from '@angular/common';
  import { InteriorDesignService } from '../../services/interior-design.service';

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

    constructor(private readonly interiorDesignService: InteriorDesignService) {}

    ngOnInit(): void {
      this.fetchServices();
    }

    fetchServices(): void {
      this.interiorDesignService.getServiceByName('R').subscribe((data: any) => {
        this.services = data;
        this.filteredServices = this.services;
      });
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
