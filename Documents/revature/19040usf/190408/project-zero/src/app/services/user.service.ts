import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private loginStatusSubject = new Subject<number>();
  public  $loginStatus = this.loginStatusSubject.asObservable();

  constructor(private httpClient: HttpClient) { }

  login(username: string, password: string): void {
    const payload = {
      username: username,
      password: password
    };

    this.httpClient.post('http://localhost:8080/Chats/login', payload, {
        observe: 'response'
      }).subscribe(response => {
        sessionStorage.setItem('cache', response.body.toString());
        this.loginStatusSubject.next(200);
      }, err => {
        this.loginStatusSubject.next(err.status);
      });
  }
}
