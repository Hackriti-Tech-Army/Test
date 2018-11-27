import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {LoginModule} from './login/login.module';
import {CustomMaterialModule} from './custom-material/custom-material.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppRoutingModule} from './app-routing.module';
import {LoggerService} from './common/LoggerService/logger.service';
import {HttpClientModule} from '@angular/common/http';
import {DashboardModule} from './dashboard/dashboard.module';
import {TitleBarModule} from './title-bar/title-bar.module';
import {SideBarModule} from './side-bar/side-bar.module';
import {RegisterUserModule} from './register-user/register-user.module';
import {TimelineModule} from './timeline/timeline.module';
import {MyAccountModule} from './my-account/my-account.module';
import {RequestHistoryModule} from './request-history/request-history.module';
import {CreateRequestModule} from './create-request/create-request.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    LoginModule,
    CustomMaterialModule,
    DashboardModule,
    TitleBarModule,
    SideBarModule,
    RegisterUserModule,
    TimelineModule,
    MyAccountModule,
    RequestHistoryModule,
    CreateRequestModule,
  ],
  providers: [
    LoggerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
