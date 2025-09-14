import { Routes } from '@angular/router';
import { TenantListComponent } from './components/tenant-list/tenant-list.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'tenants', component: TenantListComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];
