import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RequestAllTicketsService {
  private RequestAllSubject = new Subject<number>();
  public $RequestAllStatus = this.RequestAllSubject.asObservable();
  constructor(private httpClient: HttpClient) { }

  Update(status:number, author:number, reimbIds:number): void {const payload = {
    reimbStatusId: status,
   authorId: author,
   reimbId: reimbIds,

  };
  this.httpClient.get('http://localhost:8080/Chats/manager', payload,{
    observe: 'response'}).subscribe(Response => {  }, err => {  });}
  }
