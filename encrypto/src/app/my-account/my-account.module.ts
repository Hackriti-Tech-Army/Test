import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MyAccountComponent } from './my-account.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    MyAccountComponent
  ],
  exports: [
    MyAccountComponent
  ]
})
export class MyAccountModule { }
