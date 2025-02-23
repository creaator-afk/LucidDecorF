import { Component } from '@angular/core';
import { NzMenuModule } from 'ng-zorro-antd/menu';
import {NzContentComponent, NzFooterComponent, NzHeaderComponent, NzLayoutComponent} from 'ng-zorro-antd/layout';
import {RouterLink, RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [NzMenuModule, NzLayoutComponent, NzHeaderComponent, NzContentComponent, RouterOutlet, NzFooterComponent, RouterLink],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent { }
