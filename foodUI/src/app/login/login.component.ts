import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { RouterService } from '../services/router.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  isSubmitting: boolean = false;
  loginError: boolean = false;

  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private router:RouterService) {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  submitLoginForm() {
    if (this.loginForm.valid) {
      this.loginService.login(this.loginForm.value).subscribe(
        data => {
          if (data.token != null){
            this.loginService.setToken(data.token);
            this.loginService.isLoggedIn.next(true);
            this.router.toDashboard();
          }
        },
        err => {
          console.log(err);
        }
      )
    }
  }
}
