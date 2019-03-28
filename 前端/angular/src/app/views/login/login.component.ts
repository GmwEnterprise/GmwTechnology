import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from 'src/app/services/local-storage.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(
    private store: LocalStorageService,
    private fb: FormBuilder,
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      phone: [null, Validators.required],
      password: [null, Validators.required],
      remember: [false]
    });
  }

  submit(): void {
    console.log(this.loginForm.value);
  }
}
