import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import User from './models/User';

@Injectable({
  providedIn: 'root'
})
export class LoginDataService {
  private statusSource = new BehaviorSubject<boolean>(false);
  currentStatus = this.statusSource.asObservable();

  private userSource = new BehaviorSubject<User>(new User());
  currentUser = this.userSource.asObservable()

  constructor() { }

  changeStatus(status:boolean){
    this.statusSource.next(status)
  }

  changeUser(user: User){
    this.userSource.next(user);
  }
}
