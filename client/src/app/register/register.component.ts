import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { User } from '../user';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm = new FormGroup({
    'username': new FormControl('', [
      Validators.required,
      Validators.minLength(6),
      Validators.maxLength(20),
      Validators.pattern("^[A-Za-z0-9]*$")
    ]),
    'email': new FormControl('', [
      Validators.required,
      Validators.email
    ]),
    'password': new FormControl('', [
      Validators.required,
      Validators.minLength(8),
    ]),
    'repeatpassword': new FormControl('', Validators.required),
    'hasAgreed': new FormControl(false, Validators.requiredTrue)
  })

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }
  public onRegister(): void {
    if (this.registerForm.value.password !== this.registerForm.value.repeatpassword) {
      alert("Re-entered password does not match.")
    } else {
      const request = {
        username: this.registerForm.value.username,
        password: this.registerForm.value.password,
        email: this.registerForm.value.email
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
