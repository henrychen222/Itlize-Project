import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserInfoService } from 'src/app/services/user-info.service';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.sass']
})
export class UserInfoComponent implements OnInit {
  imgUrl: string;

  constructor(
    private authenticationService: AuthenticationService,
    private userInfoService: UserInfoService
  ) {}

  ngOnInit() {}

  logout() {
    this.authenticationService.logout();
  }

  updateImg() {
    this.userInfoService.changeAvatar(this.imgUrl).subscribe(
      data => {
        this.imgUrl = '';
      },
      (err: HttpErrorResponse) => {
        alert(err.error.message);
        alert('Your link is too long');
      }
    );
  }
}
