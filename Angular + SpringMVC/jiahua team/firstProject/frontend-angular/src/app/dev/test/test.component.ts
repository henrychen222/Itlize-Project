import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserLogin } from 'src/app/models/userLogin';
import { tap } from 'rxjs/operators';
import { UserInfoService } from 'src/app/services/user-info.service';
import { ItemService } from 'src/app/services/item.service';

const userLogin: UserLogin = {
  username: 'admin',
  email: 'admin@test.com',
  password: 'password'
};

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.sass']
})
export class TestComponent implements OnInit {
  constructor(
    private testService: TestService,
    private authenticationService: AuthenticationService,
    private userInfoService: UserInfoService,
    private itemService: ItemService
  ) {}

  ngOnInit() {
    // this.authenticationService.logout();
    // this.login();
    // this.testItem();
  }

  testItem() {
    this.itemService
      .fetchItems({ category: 'Delaware', subCategory: 'Tuskahoma' })
      .subscribe(console.log);
  }

  testErrorUserLogin() {
    const errorUser = {
      username: 'nullend',
      email: 'nah@spring.com',
      password: 'backend'
    };
    this.authenticationService.login(errorUser).subscribe(console.log);
  }

  testUserInfo() {
    this.userInfoService.ObserveUserInfo().subscribe(console.log);
  }

  getUserInfo() {
    this.authenticationService.login(userLogin).subscribe(u => {
      console.log(`get userLoginResponse: ${u}`);
      this.userInfoService.getInfo(u.userLogin).subscribe(console.log);
    });
  }

  authLoads() {
    this.authenticationService.login(userLogin).subscribe(data => {
      this.testService.getAddress().subscribe(console.log);
      this.testService.getCategories().subscribe(console.log);
      this.testService.getProduct().subscribe(console.log);
    });
  }

  authLoadAddress() {
    this.authenticationService.login(userLogin).subscribe(data => {
      this.testService.getAddress().subscribe(console.log);
    });
  }

  loadAddress() {
    this.testService.getAddress().subscribe(console.log);
  }

  loadCategories() {
    this.testService.getCategories().subscribe(console.log);
  }

  loadProduct() {
    this.testService.getProduct().subscribe(console.log);
  }

  loadUserLogin() {
    this.testService.getUserLogin().subscribe(console.log);
  }

  register() {
    this.authenticationService.register(userLogin).subscribe(console.log);
  }

  login() {
    this.authenticationService.login(userLogin).subscribe(console.log);
  }

  getToken() {
    this.authenticationService.observeToken().subscribe(console.log);
  }

  getExpiration() {
    this.authenticationService.observeExpiration().subscribe(console.log);
  }

  testAuth() {
    this.authenticationService
      .login(userLogin)
      .pipe(
        tap(data => {
          console.log(this.authenticationService.isAuthenticated());
        }),
        tap(data => {
          this.authenticationService.logout();
        }),
        tap(data => {
          console.log(this.authenticationService.isAuthenticated());
        }),
        tap(data => {
          this.authenticationService.login(userLogin).subscribe(() => {
            console.log(this.authenticationService.isAuthenticated());
          });
        })
      )
      .subscribe();
  }
}
