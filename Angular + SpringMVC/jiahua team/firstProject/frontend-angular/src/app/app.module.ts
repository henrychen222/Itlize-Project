import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestComponent } from './dev/test/test.component';
import { httpInterceptorProviders } from './services/interceptor';
import { MaterialModule } from './modules/material/material.module';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { SearchComponent } from './components/search/search.component';
import { HomeComponent } from './components/home/home.component';
import { QueryComponent } from './components/query/query.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { AvatarComponent } from './components/avatar/avatar.component';
import { UserComponent } from './components/user/user.component';
import { UserInfoComponent } from './components/user-info/user-info.component';
import { CompareComponent } from './components/compare/compare.component';
import { ItemComponent } from './components/item/item.component';
import { SimpleTableComponent } from './components/simple-table/simple-table.component';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    LoginComponent,
    RegisterComponent,
    SearchComponent,
    HomeComponent,
    QueryComponent,
    NavigationComponent,
    AvatarComponent,
    UserComponent,
    UserInfoComponent,
    CompareComponent,
    ItemComponent,
    SimpleTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent],
  entryComponents: []
})
export class AppModule {}
