import {Component, OnInit} from '@angular/core';
import {LoggerService} from '../common/LoggerService/logger.service';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {

  constructor(private log: LoggerService) {
  }

  ngOnInit() {
    this.log.debug('Timeline loaded!!!');
  }

}
