import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppComponent } from '../app.component';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  BASE_URL = AppComponent.BASE_URL;

  constructor(private client : HttpClient) { }

  getConfirmation(data:object):Observable<any>{
    let httpOptions = {
      headers: new HttpHeaders()
    }
    httpOptions.headers.append('Content-Type', 'application/json');
    return this.client.post<object>(this.BASE_URL+'/users/check', data, httpOptions)
  }
}
