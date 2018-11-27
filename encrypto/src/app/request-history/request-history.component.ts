import { Component, OnInit } from '@angular/core';
import {LoggerService} from '../common/LoggerService/logger.service';

@Component({
  selector: 'app-request-history',
  templateUrl: './request-history.component.html',
  styleUrls: ['./request-history.component.css']
})
export class RequestHistoryComponent implements OnInit {

  constructor(private log: LoggerService) { }

  ngOnInit() {
    this.log.debug('RequestHistoryComponent loaded!!!');
  }

}
