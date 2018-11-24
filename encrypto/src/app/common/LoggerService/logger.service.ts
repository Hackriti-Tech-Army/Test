import {Injectable} from '@angular/core';


@Injectable()
export class LoggerService {

  info(message: any) {
      console.info(message);
  }

  debug(message: any) {
      console.debug(message);
  }

  warn(message: any) {
      console.warn(message);
  }

  error(message: any) {
      console.error(message);
  }
}
