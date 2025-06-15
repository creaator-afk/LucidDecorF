import {Component, OnInit} from '@angular/core';
import {CurrencyPipe, NgClass, NgForOf, NgIf} from '@angular/common';
import {Router} from '@angular/router';
// import { InteriorDesignService} from '../../services/interior-design.service';
import {FormsModule} from '@angular/forms';

interface Service {
  image: string;
  id: number;
  name: string;
  description: string;
  price: number;
}
interface Filters {
  id: number;
  name: string;
  dropdown: {
    key: string;
  };
}

@Component({
  selector: 'app-view-featured-services',
  standalone: true,
  templateUrl: './view-featured-services.component.html',
  imports: [
    NgForOf,
    NgIf,
    CurrencyPipe,
    NgClass,
    FormsModule
  ],
  styleUrls: ['./view-featured-services.component.css']
})
export class ViewFeaturedServicesComponent implements OnInit {
  services: Service[] = [];
  filter: Filters[] = [
    {
      id: 1,
      name: 'Service 1',
      dropdown: {
        key:'value'
      },
    },
    {
      id: 2,
      name: 'Service 2',
      dropdown: {
        key:'value'
      },
    },
    {
      id: 3,
      name: 'Service 3',
      dropdown: {
        key:'value'
      },
    },
    {
      id: 4,
      name: 'Service 4',
      dropdown: {
        key:'value'
      },
    },
    {
      id: 5,
      name: 'Service 5',
      dropdown: {
        key:'value'
      },
    },
    {
      id: 6,
      name: 'Service 6',
      dropdown: {
        key:'value'
      },
    },
  ];
  selectedCategory: string = 'All';
  categories: string[] = ['All', 'Service 1', 'Service 2', 'Service 3', 'Service 4', 'Service 5', 'Service 6'];

  constructor(
    private readonly router: Router,
    // private readonly interiorDesignService: InteriorDesignService
  ) {}

  ngOnInit(): void {
    this.fetchFeaturedServices();
  }

  bookService(service: number): void {
    this.router.navigate(['/book-service', service]);
  }

  fetchFeaturedServices(): void {
    // Simulate fetching data from a service
    // this.interiorDesignService.getAllServices().subscribe((data: any) => {
    //   this.services = data
    // });
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

  filterServices() {
    // Implement filtering logic here
    // For example, filter services based on selectedCategory
    if (this.selectedCategory === 'All') {
      this.fetchFeaturedServices();
    } else {
      this.services = this.services.filter(service => service.name === this.selectedCategory);
    }
  }

  previousImage() {

  }

  nextImage() {

  }
}
