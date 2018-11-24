import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule, MatDivider, MatDividerModule, MatInputModule, MatProgressSpinner, MatSpinner} from '@angular/material';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatDividerModule,
    MatInputModule,
  ],
  declarations: [],
  exports: [
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatDividerModule,
    MatInputModule,
  ]
})
export class CustomMaterialModule { }
