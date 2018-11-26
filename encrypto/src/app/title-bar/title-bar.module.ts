import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {TitleBarComponent} from './title-bar.component';
import {CustomMaterialModule} from '../custom-material/custom-material.module';

@NgModule({
  imports: [
    CommonModule,
    CustomMaterialModule
  ],
  declarations: [
    TitleBarComponent
  ],
  exports: [
    TitleBarComponent
  ]
})
export class TitleBarModule { }
