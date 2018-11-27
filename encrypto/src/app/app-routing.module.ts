import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {AuthGaurdService} from './common/AuthGaurdService/auth-gaurd.service';
import {RegisterUserComponent} from './register-user/register-user.component';
import {CreateRequestComponent} from './create-request/create-request.component';
import {RequestHistoryComponent} from './request-history/request-history.component';
import {MyAccountComponent} from './my-account/my-account.component';
import {TimelineComponent} from './timeline/timeline.component';

const routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    children: [
      {
        path: '',
        redirectTo: 'timeline',
        pathMatch: 'full'
      },
      {
        path: 'timeline',
        component: TimelineComponent
      },
      {
        path: 'register-user',
        component: RegisterUserComponent
      },
      {
        path: 'create-request',
        component: CreateRequestComponent
      },
      {
        path: 'request-history',
        component: RequestHistoryComponent
      },
      {
        path: 'my-account',
        component: MyAccountComponent
      },
    ],
    canActivate: [AuthGaurdService]
  },
  {
    path: '**',
    component: LoginComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
