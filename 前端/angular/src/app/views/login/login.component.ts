import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  type = 1;

  toRegister() {
    this.type = 2;
  }

  toLanding() {
    this.type = 1;
  }

  constructor() { }

  ngOnInit() {

  }
}
