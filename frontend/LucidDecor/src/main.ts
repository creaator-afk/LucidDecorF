import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));

//TODO 2: Create UI for displaying available services
//TODO 3: Add booking consultation form with validation
//TODO 4: Integrate payment gateway in frontend
//TODO 5: Resolve issue with mobile responsiveness in service pag
//TODO 6: Add responsive design for mobile and tablet views
//TODO 7: Improve accessibility for visually impaired users
//TODO 8: Refactor UI components for consistency
