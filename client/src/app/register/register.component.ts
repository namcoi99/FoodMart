import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../user';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }
  public onRegister(registerForm: NgForm): void {
    console.log(registerForm.value)
    this.userService.register(registerForm.value).subscribe(
      (response: User) => {
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
