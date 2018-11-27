import { Component, OnInit } from '@angular/core';
import {LoggerService} from '../common/LoggerService/logger.service';

@Component({
  selector: 'app-create-request',
  templateUrl: './create-request.component.html',
  styleUrls: ['./create-request.component.css']
})
export class CreateRequestComponent implements OnInit {

  constructor(private log: LoggerService) { }

  ngOnInit() {
    this.log.debug('CreateRequestComponent loaded!!!');
  }

}
