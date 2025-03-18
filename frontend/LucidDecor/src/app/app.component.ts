import {Component, OnInit} from '@angular/core';
import {HomePageComponent} from './home-page/home-page.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {LogoutComponent} from './logout/logout.component';
import {NgIf} from '@angular/common';
import {ActivatedRoute, NavigationEnd, Router, RouterOutlet} from '@angular/router';
import {filter} from 'rxjs';
import {BookServiceComponent} from './dashboard/book-service/book-service.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HomePageComponent, DashboardComponent, LogoutComponent, NgIf, BookServiceComponent, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'LucidDecor';
  selectedComponent: string = 'home';

  constructor(private readonly router: Router, private readonly route: ActivatedRoute) {
  }

  ngOnInit() {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => {
        const currentRoute = this.route.snapshot.firstChild?.routeConfig?.path;
        this.selectedComponent = currentRoute || 'home';
      }
    )
  }

  selectComponent(component: string): void {
    this.selectedComponent = component;
  }
}
