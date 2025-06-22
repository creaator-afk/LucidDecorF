import {Component, OnInit} from '@angular/core';
import {CurrencyPipe, NgClass, NgForOf, NgIf} from '@angular/common';
import {Router, RouterLink} from '@angular/router';
// import { InteriorDesignService} from '../../services/interior-design.service';
import {FormsModule} from '@angular/forms';
import {SearchForServicesComponent} from '../search-for-services/search-for-services.component';

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
    FormsModule,
    RouterLink,
    SearchForServicesComponent
  ],
  styleUrls: ['./view-featured-services.component.css']
})
export class ViewFeaturedServicesComponent implements OnInit {
  services: any[] = [];
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
        priceOptions: ['Basic: ₹25,000', 'Premium: ₹35,000', 'Luxury: ₹50,000'],
        stars: 5,
        reviews: 128,
        rating: 4.9,
        verified: true,
        sellerProfile: 'assets/images/seller1.jpg'
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
        priceOptions: ['Standard: ₹12,000', 'Advanced: ₹18,000'],
        stars: 4,
        reviews: 67,
        rating: 4.6,
        verified: true,
        sellerProfile: 'assets/images/seller2.jpg'
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
        priceOptions: ['Basic: ₹40,000', 'Complete: ₹60,000'],
        stars: 5,
        reviews: 85,
        rating: 4.8,
        verified: true,
        sellerProfile: 'assets/images/seller3.jpg'
      }
    ]
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
