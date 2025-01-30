import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));

//TODO Add login and registration forms in Angular
//TODO Create UI for displaying available services
//TODO Add booking consultation form with validation
//TODO Integrate payment gateway in frontend
//TODO: Resolve issue with mobile responsiveness in service page
//TODO Add responsive design for mobile and tablet views
//TODO Improve accessibility for visually impaired users
//TODO Refactor UI components for consistency
