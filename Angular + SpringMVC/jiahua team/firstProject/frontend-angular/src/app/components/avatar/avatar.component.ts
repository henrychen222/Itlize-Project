import { Component, OnInit } from '@angular/core';

import { UserInfoService } from 'src/app/services/user-info.service';

@Component({
  selector: 'app-avatar',
  templateUrl: './avatar.component.html',
  styleUrls: ['./avatar.component.sass']
})
export class AvatarComponent implements OnInit {
  imgUrl = '';
  defaultImg = 'https://source.unsplash.com/random';

  constructor(private userInfoService: UserInfoService) {}

  ngOnInit() {
    this.syncImg();
  }

  syncImg() {
    this.userInfoService
      .ObserveUserInfo()
      .subscribe(userInfo =>
        userInfo ? (this.imgUrl = userInfo.picturePath) : null
      );
  }
}
