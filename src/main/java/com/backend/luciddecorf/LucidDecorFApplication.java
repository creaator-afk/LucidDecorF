package com.backend.luciddecorf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LucidDecorFApplication {

    public static void main(String[] args) {
        SpringApplication.run(LucidDecorFApplication.class, args);
    }

}

//TODO: Project Roadmap
// 1. [main] Initialize repository with README and .gitignore [completed]
// 2. [main] Add project structure: backend (Spring Boot) and frontend (Angular)
// 3. [feature/backend-setup] Set up Spring Boot project structure
// 4. [feature/backend-setup] Add basic REST API for health check
// 5. [feature/backend-setup] Add database configuration(MySQL)
// 6. Merge feature/backend-setup into develop
// 7. [feature/frontend-setup] Initialize Angular project
// 8. [feature/frontend-setup] Initialize Angular project
// 9. [feature/frontend-setup] Add routing with home and services pages
// 10. [feature/frontend-setup] Create basic layout and navigation bar
// 11. Merge feature/frontend-setup into develop
// 12. [feature/authentication] Add user registration API
// 13. [feature/authentication] Add JWT-based login system
// 14. [feature/authentication] Integrate Spring Security
// 15. [feature/authentication] Add login and registration forms in Angular
// 16. [feature/authentication] Integrate authentication service with backend API
// 17. Merge feature/authentication into develop
// 18. [feature/core-features] Create interior design services API (CRUD)
// 19. [feature/core-features] Add booking and consultation endpoints
// 20. [feature/core-features] Implement payment gateway integration
// 21. [feature/core-features] Create UI for displaying available services
// 22. [feature/core-features] Add booking consultation form with validation
// 23. [feature/core-features] Integrate payment gateway (Razorpay)
// 24. Merge feature/core-features into develop
// 25. [feature/database-optimization] Optimize database schema for services
// 26. [feature/database-optimization] Implement search functionality
// 27. [feature/database-optimization] Add search bar for services
// 28. [feature/database-optimization] Display search results dynamically
// 29. Merge feature/database-optimization into develop
// 30. [feature/ui-ux] Add responsive design for mobile and tablet views
// 31. [feature/ui-ux] Improve accessibility for visually impaired users
// 32. [feature/ui-ux] Refactor UI components for consistency
// 33. Merge feature/ui-ux into develop
// 34. [bugfix/api-endpoints] Fix bug in booking consultation API
// 35. [bugfix/ui-glitch] Resolve issue with mobile responsiveness in service page
// 36. Merge bugfix into develop
// 37. [release/1.0] Update README and project documentation
// 38. [release/1.0] Final round of testing for production
// 39. [release/1.0] Configure deployment scripts (AWS)
// 40. Merge release/1.0 into main