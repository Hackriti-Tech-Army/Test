import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {TimelineComponent} from './timeline.component';
import {RouterModule} from '@angular/router';

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
  ],
  declarations: [
    TimelineComponent
  ],
  exports: [
    TimelineComponent
  ]
})
export class TimelineModule { }
