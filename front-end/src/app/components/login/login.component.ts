import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // Adicionando CommonModule
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms'; // Módulos para formulários reativos
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule], // Importando os módulos necessários
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm: FormGroup; // Declaração do formulário

  constructor(private fb: FormBuilder, private authService: AuthService) {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const { username, password } = this.loginForm.value;
      this.authService.login(username, password).subscribe(
        response => {
          console.log('Login successful', response);
          // Lógica para redirecionar o usuário
        },
        error => {
          console.error('Login failed', error);
          // Lógica para mostrar erro ao usuário
        }
      );
    }
  }
}