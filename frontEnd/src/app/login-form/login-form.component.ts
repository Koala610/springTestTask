import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { LoginDataService } from 'src/login-data.service';
import User from 'src/models/User';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  formData:any;

  constructor(private loginService: LoginService,
              private router: Router,
              private loginDataService: LoginDataService) { }

  ngOnInit(): void {
  }

  sendDataToAPI(form:NgForm){
    const data = {
      "username": form.value.login,
      "password": form.value.password
    }
    this.loginService.getConfirmation(data).subscribe({
      next: (value:any) => {
        if(value.response === true){
          this.loginDataService.changeStatus(true);
          this.loginDataService.changeUser(value.body);
          this.router.navigate(['/']);
        }
        
      },
      error: (e) => console.log(e),
    });
    
  }

}
