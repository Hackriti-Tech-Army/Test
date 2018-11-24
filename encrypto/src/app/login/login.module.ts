import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login.component';
import {CustomMaterialModule} from "../custom-material/custom-material.module";
import {ReactiveFormsModule} from "@angular/forms";
import {LoginService} from "./login.service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    CustomMaterialModule,
    HttpClientModule
  ],
  declarations: [LoginComponent],
  exports: [
    LoginComponent
  ],
  providers: [
    LoginService,
  ]
})
export class LoginModule { }
