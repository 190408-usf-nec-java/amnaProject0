import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  username = '';
  password = '';
  loginResponse: Subscription;
  lastStatus = 200;

  constructor(private userService: UserService, private router: Router) { }
  ngOnInit() {
    this.loginResponse = this.userService.$loginStatus.subscribe(status => {
      // do something with the status here
      if (status === 200) {
        this.router.navigateByUrl('employee');
      } else {
        // set status to lastStatus to display appropriate error message
        this.lastStatus = status;
      }
    });
  }

  ngOnDestroy() {
    if (this.loginResponse) {
      this.loginResponse.unsubscribe();
    }
  }

  formValidation(): boolean {
    return this.username.length > 0 && this.password.length > 0;
  }

  submit() {
    this.userService.login(this.username, this.password);
  }
}