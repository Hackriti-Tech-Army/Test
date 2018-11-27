import { Component, OnInit } from '@angular/core';
import {LoggerService} from '../common/LoggerService/logger.service';

@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.css']
})
export class MyAccountComponent implements OnInit {

  constructor(private log: LoggerService) { }

  ngOnInit() {
    this.log.debug('MyAccountComponent loaded!!!');
  }

}
