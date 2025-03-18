import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './navigate-to-login-register.component.html',
  styleUrls: ['./navigate-to-login-register.component.css']
})
export class NavigateToLoginRegisterComponent {
  loginData = { username: '', password: '' };
  registerData = { username: '', password: '', email: '' };

  onLogin(): void {
    // Implement login logic here
    console.log('Login data:', this.loginData);
  }

  onRegister(): void {
    // Implement registration logic here
    console.log('Register data:', this.registerData);
  }
}
