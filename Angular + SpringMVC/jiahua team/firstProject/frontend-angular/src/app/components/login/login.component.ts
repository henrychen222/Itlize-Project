import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { UserLogin } from 'src/app/models/userLogin';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private authenticationService: AuthenticationService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      name: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit() {
    if (this.authenticationService.isAuthenticated()) {
      this.router.navigate(['home']);
    }
  }

  onSubmit() {
    this.submitted = true;

    if (!this.loginForm.valid) {
      return;
    } else {
      const value = this.loginForm.value;
      // tslint:disable-next-line: max-line-length
      const regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

      if (regex.test(value.name)) {
        value.email = value.name;
      } else {
        value.username = value.name;
      }

      this.handleLogin(value as UserLogin);
    }
  }

  handleLogin(userLogin: UserLogin) {
    this.authenticationService.login(userLogin).subscribe(
      user => {
        this.router.navigate(['home']);
      },
      (err: HttpErrorResponse) => {
        alert(err.error.message);
      }
    );
  }
}
