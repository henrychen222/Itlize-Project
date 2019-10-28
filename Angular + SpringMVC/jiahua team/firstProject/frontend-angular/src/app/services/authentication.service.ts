import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

import { environment } from 'src/environments/environment';
import { UserLogin } from '../models/userLogin';
import { UserLoginResponse } from '../models/userLoginResponse';

const apiUrl = environment.apiUrl;
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private token = new BehaviorSubject<string | null>(null);
  private expiration = new BehaviorSubject<string | null>(null);
  private userLogin = new BehaviorSubject<UserLogin | null>(null);
  private authStatus = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient, private router: Router) {
    this.initFromLocal();
    this.refreshingLocal();

    this.token.subscribe(token => {
      if (token && this.isAuthenticated()) {
        this.authStatus.next(true);
      } else {
        this.authStatus.next(false);
      }
    });
  }

  initFromLocal(): void {
    const token = localStorage.getItem('token');
    if (token) {
      this.token.next(token);
    }

    const expiration = localStorage.getItem('expiration');
    if (expiration) {
      this.expiration.next(expiration);
    }

    const userLogin = localStorage.getItem('userLogin');
    if (userLogin) {
      this.userLogin.next(JSON.parse(userLogin));
    }
  }

  refreshingLocal(): void {
    this.token.subscribe(t => {
      if (localStorage.getItem('token') !== t) {
        localStorage.setItem('token', t);
      }
    });

    this.expiration.subscribe(e => {
      if (localStorage.getItem('expiration') !== e) {
        localStorage.setItem('expiration', e);
      }
    });

    this.userLogin.subscribe(u => {
      if (localStorage.getItem('userLogin') !== JSON.stringify(u)) {
        localStorage.setItem('userLogin', JSON.stringify(u));
      }
    });
  }

  refreshToken = data => this.token.next(data.token);
  refreshExpiration = data => this.expiration.next(data.expiration);
  refreshUserLogin = data => this.userLogin.next(data.userLogin);

  register(user: UserLogin): Observable<UserLoginResponse> {
    return this.http
      .post<UserLoginResponse>(`${apiUrl}/auth/register`, user)
      .pipe(
        tap(this.refreshToken),
        tap(this.refreshExpiration),
        tap(this.refreshUserLogin)
      );
  }

  login(user: UserLogin): Observable<UserLoginResponse> {
    return this.http.post<UserLoginResponse>(`${apiUrl}/auth/login`, user).pipe(
      tap(this.refreshToken),
      tap(this.refreshExpiration),
      tap(this.refreshUserLogin)
    );
  }

  logout(): void {
    this.token.next(null);
    this.expiration.next(null);
    this.userLogin.next(null);
    this.router.navigate(['/login']);
  }

  observeToken(): Observable<string | null> {
    return this.token.asObservable();
  }

  observeExpiration(): Observable<string | null> {
    return this.expiration.asObservable();
  }

  observeUserLogin(): Observable<UserLogin | null> {
    return this.userLogin.asObservable();
  }

  observeAuthStatus(): Observable<boolean> {
    return this.authStatus.asObservable();
  }

  isAuthenticated(): boolean {
    const token = this.token.getValue();
    if (!token) {
      return false;
    }

    const expiration = this.expiration.getValue();
    return expiration !== null ? new Date(expiration) >= new Date() : false;
  }

  getTokenValue(): string | null {
    return this.token.getValue();
  }
}
