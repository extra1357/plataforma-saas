import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    // Substitua com a lógica real de login da sua API
    // Por exemplo: return this.http.post('http://localhost:8080/api/auth/login', { username, password });
    
    // Simulação de login para testes
    if (username === 'admin' && password === '123456') {
      return of({ message: 'Login successful' });
    } else {
      return of({ message: 'Login failed' });
    }
  }
}