import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UpdateService {
  private UpdateSubject = new Subject<number>();
  public $UpdateStatus = this.UpdateSubject.asObservable();
  constructor(private httpClient: HttpClient) { }

  Update(status:number, author:number, reimbIds:number): void {const payload = {
    reimbStatusId: status,
   authorId: author,
   reimbId: reimbIds,

  };
  this.httpClient.post('http://localhost:8080/Chats/updateRequest', payload,{
  observe: 'response'}).subscribe(Response => {  }, err => {  });}
  }

