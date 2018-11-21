import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {LoginModel} from "../models/LoginModel";
import {LoginService} from "./login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  username = new  FormControl('');
  password = new  FormControl('');
  constructor(private loginService: LoginService) {
    this.loginForm = new FormGroup({
      username: this.username,
      password: this.password
    });
  }

  ngOnInit() {
  }

  loginUser() {
    console.log('Login button clicked');
    console.log('Username : ' + this.username.value);
    console.log('Password : ' + this.password.value);
    const msg = new LoginModel();
    msg.userName = this.username.value;
    msg.password = this.password.value;
    this.loginService.loginUser(msg);
  }
}
