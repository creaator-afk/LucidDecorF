# LucidDecorF

Welcome to LucidDecorF, a comprehensive interior design service application. This project integrates both backend and frontend technologies to provide a seamless user experience. The backend is built with Spring Boot, while the frontend is developed using Angular.

## Project Overview

LucidDecorF aims to offer a full-fledged platform for interior design services, including user authentication, service booking, payment integration, and more. Below is a detailed roadmap of the project features and their implementation steps.

### Main Setup
We started by setting up the repository with a `README` and `.gitignore` file. The project structure was established with separate directories for the backend (Spring Boot) and frontend (Angular).

### Backend Setup
The backend project was set up using Spring Boot. A basic REST API was added to check the health of the application, and MySQL was configured as the database for the application.

### Frontend Setup
The frontend project was initialized using Angular. Routing was set up with home and services pages, and a basic layout and navigation bar were created for the application.

### Authentication
An API was added to handle user registration, and a login system using JWT (JSON Web Tokens) was implemented. Spring Security was integrated to manage authentication and authorization. Forms for login and registration were added to the Angular frontend, and the authentication service was integrated with the backend API.

### Core Features
A CRUD API was created for managing interior design services, and endpoints were added for booking and consultation services. Razorpay was integrated as the payment gateway. A user interface was created to display available services, and a form with validation was added for booking consultations.

### Database Optimization
The database schema was optimized for better performance. Search functionality was implemented to allow users to search for services, a search bar was added to the frontend for service searches, and search results were displayed dynamically as users typed in the search bar.

### UI/UX Improvements
The application was made responsive for mobile and tablet views. Accessibility features were added to support visually impaired users, and UI components were refactored for consistency across the application.

### Bug Fixes
A bug in the booking consultation API was fixed, and an issue with mobile responsiveness on the service page was resolved.

### Release 1.0
The `README` and project documentation were updated. A final round of testing was conducted to ensure the application was ready for production, and deployment scripts were configured for AWS.

## Getting Started

### Prerequisites
- Java 11 or higher
- Node.js and npm
- MySQL

### Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/yourusername/LucidDecorF.git
   cd LucidDecorF# LucidDecorF