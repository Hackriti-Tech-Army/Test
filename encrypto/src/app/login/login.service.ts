import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {LoginModel} from '../models/LoginModel';

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) {
  }

  loginUser(msg: LoginModel) {
    const url = 'https://9li1fxbjw2.execute-api.us-east-2.amazonaws.com/dev/login';
    console.log(JSON.stringify(msg));
    return this.http.post(url, JSON.stringify(msg)).toPromise();
  }
}
