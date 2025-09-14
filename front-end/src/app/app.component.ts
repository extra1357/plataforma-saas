import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet], // 👈 Import do RouterOutlet
  templateUrl: './app.component.html',
  styleUrls: ['./app.scss']
})
export class AppComponent {
  title = 'front-end';
}
