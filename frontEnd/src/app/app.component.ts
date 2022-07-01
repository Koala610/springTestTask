import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { LoginDataService } from 'src/login-data.service';
import User from 'src/models/User';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  static BASE_URL = 'http://localhost:8080'
  title = 'eschool';
  isLogged = false;
  innerText = this.isLogged ? "Logout" : "Login";
  homeLink = this.isLogged ? "/" : "/login";
  currentUser!:User;

  constructor(private router: Router, private loginDataService: LoginDataService){
  }

  ngOnInit(){
    this.loginDataService.currentStatus.subscribe(value=>{
      this.isLogged = value;
      this.innerText = this.isLogged ? "Logout" : "Login";
      this.homeLink = this.isLogged ? "/" : "/login";
      
    })

    this.loginDataService.currentUser.subscribe(user=>{
      this.currentUser=user;
      
    })
    if(!this.isLogged)this.router.navigate(['/login']);
  }


  buttonClick(){
    console.log(this.isLogged);
    
  }

  logOut(){
    this.loginDataService.changeStatus(false);
    this.isLogged = false;
  }
}
