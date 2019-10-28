import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  FormControl
} from '@angular/forms';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserLogin } from 'src/app/models/userLogin';

const NotEmail = (control: FormControl) => {
  // tslint:disable-next-line: max-line-length
  const regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

  return regex.test(control.value) ? { isEmail: true } : null;
};

const checkPassword = (group: FormGroup) => {
  const password = group.controls.password.value;
  const confirmPassword = group.controls.confirm.value;

  return password === confirmPassword ? null : { diff: true };
};

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private authenticationService: AuthenticationService,
    private router: Router
  ) {
    this.registerForm = this.fb.group(
      {
        username: ['', [Validators.required, NotEmail]],
        email: ['', Validators.required],
        password: ['', Validators.required],
        confirm: ['']
      },
      { validators: [checkPassword] }
    );
  }

  ngOnInit() {
    if (this.authenticationService.isAuthenticated()) {
      this.router.navigate(['home']);
    }
  }

  onSubmit() {
    this.submitted = true;
    if (!this.registerForm.valid) {
      return;
    } else {
      const value = this.registerForm.value;
      this.handleRegister(value);
    }
  }

  handleRegister(userLogin: UserLogin) {
    this.authenticationService.register(userLogin).subscribe(
      userLoginResponse => {
        this.router.navigate(['/']);
      },
      (err: HttpErrorResponse) => {
        alert(err.error.message);
      }
    );
  }
}
