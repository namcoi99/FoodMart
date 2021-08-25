import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  public onLogin(loginForm: NgForm): void {
    console.log(loginForm.value);
    this.userService.login(loginForm.value).subscribe(
      (response: User) => {
        console.log(response);
        localStorage.setItem("username", response.username);
        this.router.navigate(['']).then(() => {
          window.location.reload();
        });
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}

