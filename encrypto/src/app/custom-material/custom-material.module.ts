import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule, MatInputModule} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule
  ],
  declarations: [],
  exports: [
    MatCardModule,
    MatInputModule,
    MatButtonModule
  ]
})
export class CustomMaterialModule { }
