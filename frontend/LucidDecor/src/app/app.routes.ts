import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { ViewFeaturedServicesComponent } from './home-page/view-featured-services/view-featured-services.component';
import { SearchForServicesComponent } from './home-page/search-for-services/search-for-services.component';
import { NavigateToLoginRegisterComponent } from './home-page/navigate-to-login-register/navigate-to-login-register.component';
import { LoginRegisterComponent } from './login-register/login-register.component';
import { LoginComponent } from './login-register/login/login.component';
import { EnterCredentialsComponent } from './login-register/login/enter-credentials/enter-credentials.component';
import { SubmitComponent as LoginSubmitComponent } from './login-register/login/submit/submit.component';
import { RegisterComponent } from './login-register/register/register.component';
import { EnterDetailsComponent } from './login-register/register/enter-details/enter-details.component';
import { SubmitComponent as RegisterSubmitComponent } from './login-register/register/submit/submit.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ViewServicesComponent } from './dashboard/view-services/view-services.component';
import { FilterServicesComponent } from './dashboard/view-services/filter-services/filter-services.component';
import { SelectServiceComponent } from './dashboard/view-services/select-service/select-service.component';
import { BookServiceComponent } from './dashboard/book-service/book-service.component';
import { SelectDateTimeComponent } from './dashboard/book-service/select-date-time/select-date-time.component';
import { ConfirmBookingComponent } from './dashboard/book-service/confirm-booking/confirm-booking.component';
import { PaymentComponent } from './dashboard/payment/payment.component';
import { EnterPaymentDetailsComponent } from './dashboard/payment/enter-payment-details/enter-payment-details.component';
import { ReviewPaymentComponent } from './dashboard/payment/review-payment/review-payment.component';
import { CompletePaymentComponent } from './dashboard/payment/complete-payment/complete-payment.component';
import { ViewBookingHistoryComponent } from './dashboard/view-booking-history/view-booking-history.component';
import { LogoutComponent } from './logout/logout.component';

export const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'view-featured-services', component: ViewFeaturedServicesComponent },
  { path: 'search-for-services', component: SearchForServicesComponent },
  { path: 'navigate-to-login-register', component: NavigateToLoginRegisterComponent },
  { path: 'login-register', component: LoginRegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'enter-credentials', component: EnterCredentialsComponent },
  { path: 'login-submit', component: LoginSubmitComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'enter-details', component: EnterDetailsComponent },
  { path: 'register-submit', component: RegisterSubmitComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'view-services', component: ViewServicesComponent },
  { path: 'filter-services', component: FilterServicesComponent },
  { path: 'select-service', component: SelectServiceComponent },
  { path: 'book-service', component: BookServiceComponent },
  { path: 'book-service/:id', component: BookServiceComponent },
  { path: 'select-date-time', component: SelectDateTimeComponent },
  { path: 'confirm-booking', component: ConfirmBookingComponent },
  { path: 'confirm-booking/:id', component: ConfirmBookingComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'enter-payment-details', component: EnterPaymentDetailsComponent },
  { path: 'review-payment', component: ReviewPaymentComponent },
  { path: 'complete-payment', component: CompletePaymentComponent },
  { path: 'view-booking-history', component: ViewBookingHistoryComponent },
  { path: 'logout', component: LogoutComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
