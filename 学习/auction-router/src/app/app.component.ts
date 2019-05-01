import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'auction-router';

  constructor(private router: Router) { }

  toProductDetails(): void {
    // 通过对象跳转路由
    this.router.navigate(['/product', 2]);
  }
}
