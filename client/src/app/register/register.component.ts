import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../user';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }
  public onRegister(registerForm: NgForm): void {
    if (registerForm.value.password !== registerForm.value.repeatpassword) {
      alert("Re-entered password does not match.")
    } else {
      const request = {
        username: registerForm.value.username,
        password: registerForm.value.password,
        email: registerForm.value.email
      }
      this.userService.register(request).subscribe(
        (response: User) => {
          console.log(response);
          this.router.navigate(['login']);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
  }
}
