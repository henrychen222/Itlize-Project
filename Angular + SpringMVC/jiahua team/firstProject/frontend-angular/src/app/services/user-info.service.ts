import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

import { AuthenticationService } from './authentication.service';
import { UserInfo } from '../models/UserInfo';
import { UserLogin } from '../models/userLogin';
import { environment } from 'src/environments/environment';

const { apiUrl } = environment;

@Injectable({
  providedIn: 'root'
})
export class UserInfoService {
  userInfo = new BehaviorSubject<UserInfo | null>(null);

  constructor(
    private http: HttpClient,
    private authenticationService: AuthenticationService
  ) {
    this.authenticationService.observeUserLogin().subscribe(userLogin => {
      if (userLogin) {
        this.getInfo(userLogin).subscribe(u => this.userInfo.next(u));
      } else {
        this.userInfo.next(null);
      }
    });
  }

  getInfo(userLogin: UserLogin): Observable<UserInfo> {
    return this.http.post<UserInfo>(`${apiUrl}/userInfo/connect`, userLogin);
  }

  ObserveUserInfo(): Observable<UserInfo | null> {
    return this.userInfo.asObservable();
  }

  changeAvatar(url: string): Observable<UserInfo> {
    const user = this.userInfo.getValue();
    if (!user) {
      console.error(
        'changeAvatar should not be triggered when there is no user logging in!'
      );
      return;
    }
    user.picturePath = url;
    return this.http
      .put<UserInfo>(`${apiUrl}/userInfo/id/${user.id}`, user)
      .pipe(tap(u => this.userInfo.next(u)));
  }
}
