import { Component, OnInit } from '@angular/core';
import {LoggerService} from '../common/LoggerService/logger.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private log: LoggerService) { }

  ngOnInit() {
    this.log.debug('Dashboard Loaded!!!');
  }

}
