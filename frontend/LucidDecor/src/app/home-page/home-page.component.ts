import {Component} from '@angular/core';
import {SearchForServicesComponent} from './search-for-services/search-for-services.component';
import {ViewFeaturedServicesComponent} from './view-featured-services/view-featured-services.component';
import {NavigateToLoginRegisterComponent} from './navigate-to-login-register/navigate-to-login-register.component';
import {NgIf} from '@angular/common';
import {RouterOutlet, Router} from '@angular/router';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [
    SearchForServicesComponent,
    ViewFeaturedServicesComponent,
    NavigateToLoginRegisterComponent,
    NgIf,
    RouterOutlet
  ],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {
  selectedComponent: string = 'view-featured-services'

  constructor(private router: Router) {}

  selectComponent(component: string) {
    this.selectedComponent = component
  }

  navigateTo(path: string) {
    this.router.navigate(['/' + path]);
  }
}
