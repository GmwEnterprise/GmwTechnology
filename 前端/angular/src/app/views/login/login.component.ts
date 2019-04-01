import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from 'src/app/services/local-storage.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { UserMessageService } from 'src/app/services/user-message.service';
import { store } from '@angular/core/src/render3';
import { Router } from '@angular/router';
import { regExpMatchesValidator } from 'src/app/utils/input.validator';
import { VALID_PHONE } from 'src/app/utils/reg.namespace';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private userService: UserMessageService,
    private router: Router
  ) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      phone: [
        null, [
          regExpMatchesValidator(VALID_PHONE)
        ]
      ],
      password: [
        null, [
          Validators.maxLength(20),
          Validators.minLength(6),
          Validators.required
        ]
      ],
      remember: [false]
    });
  }

  submit(): void {
    const formData = this.loginForm.value;
    this.userService.login(formData)
      .subscribe(data => {
        console.log(data);
        /*
        this.ls.set('currentUser', data.currentUser);
        this.ls.set('token', data.token);*/
        // this.router.navigateByUrl('/home');
      }, (error: HttpErrorResponse) => alert('登陆异常: ' + error.message));
  }
}
