import { Component, OnInit } from '@angular/core';
import {LoggerService} from '../common/LoggerService/logger.service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  constructor(private log: LoggerService) { }

  ngOnInit() {
    this.log.debug('RegisterUserComponent loaded!!!');
  }

}
