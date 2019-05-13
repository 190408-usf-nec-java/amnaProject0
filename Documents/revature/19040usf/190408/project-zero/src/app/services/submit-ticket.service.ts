import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Reimbursements } from '../Reimbursements';
@Injectable({
  providedIn: 'root'
})
export class SubmitTicketService {
  private SubmitSubject = new Subject<number>();
  public $SubmitStatus = this.SubmitSubject.asObservable();
  submitArray = new Array <Reimbursements>();
  constructor(private httpClient: HttpClient) { }
  SubmitNew( amount: number, description: string, type_id: number, status: number): void {const payload = {
    reimbAmount: amount,
    reimbDescription: description,
    reimbTypeId:type_id,
    reimbResolver: 1,
    reimbStatusId:status,
  };
  this.httpClient.post('http://localhost:8080/Chats/submitreimbursement', payload,{
  observe: 'response'}).subscribe(Response => {  }, err => {  });}
  }
