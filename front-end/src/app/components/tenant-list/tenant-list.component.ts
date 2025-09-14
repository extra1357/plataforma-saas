import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; // Importação do CommonModule
import { TenantService } from '../../services/tenant.service';

@Component({
  selector: 'app-tenant-list',
  standalone: true,
  imports: [CommonModule], // Adicionando CommonModule aos imports
  templateUrl: './tenant-list.component.html',
  styleUrl: './tenant-list.component.css' // Corrigindo para styleUrl (pode variar)
})
export class TenantListComponent implements OnInit {
  tenants: any[] = [];

  constructor(private tenantService: TenantService) {}

  ngOnInit(): void {
    this.tenantService.getTenants().subscribe((data: any[]) => {
      this.tenants = data;
    });
  }
}