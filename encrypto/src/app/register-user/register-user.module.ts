import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RegisterUserComponent} from './register-user.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    RegisterUserComponent
  ],
  exports: [
    RegisterUserComponent
  ]
})
export class RegisterUserModule { }
