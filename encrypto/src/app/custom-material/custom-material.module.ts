import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MatCardModule} from '@angular/material/card';
import {
  MatButtonModule,
  MatDivider,
  MatDividerModule, MatDrawerContainer, MatIconModule,
  MatInputModule, MatListModule, MatProgressBarModule,
  MatProgressSpinner, MatSelectModule,
  MatSidenavModule,
  MatSpinner
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatDividerModule,
    MatInputModule,
    MatSidenavModule,
    MatSelectModule,
    MatListModule,
    MatIconModule,
    MatProgressBarModule
  ],
  declarations: [],
  exports: [
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatDividerModule,
    MatInputModule,
    MatSidenavModule,
    MatSelectModule,
    MatListModule,
    MatIconModule,
    MatProgressBarModule
  ]
})
export class CustomMaterialModule {
}
