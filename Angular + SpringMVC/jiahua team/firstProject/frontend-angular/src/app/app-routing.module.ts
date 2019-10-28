import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { environment } from 'src/environments/environment';
import { TestComponent } from './dev/test/test.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AuthGuardService } from './services/auth-guard.service';
import { HomeComponent } from './components/home/home.component';
import { QueryComponent } from './components/query/query.component';
import { UserComponent } from './components/user/user.component';
import { UserInfoComponent } from './components/user-info/user-info.component';
import { CompareComponent } from './components/compare/compare.component';
import { ItemComponent } from './components/item/item.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'user',
    component: UserComponent,
    canActivate: [AuthGuardService],
    children: [
      {
        path: 'info',
        component: UserInfoComponent
      },
      {
        path: 'query',
        children: [
          {
            path: 'id/:id',
            component: ItemComponent
          },
          {
            path: ':category',
            component: QueryComponent
          },
          {
            path: ':category/:subCategory',
            component: QueryComponent
          }
        ]
      },
      {
        path: 'compare',
        component: CompareComponent
      }
    ]
  }
  // ,
  // {
  //   path: '**',
  //   redirectTo: 'login'
  // }
];

if (!environment.production) {
  routes.push({
    path: 'test',
    component: TestComponent
  });
  routes.push({
    path: '**',
    redirectTo: 'login'
  });
}

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
