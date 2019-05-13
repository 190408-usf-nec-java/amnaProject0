import { Component, OnInit } from '@angular/core';
import { Reimbursements } from 'src/app/Reimbursements';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-request-ticket',
  templateUrl: './request-ticket.component.html',
  styleUrls: ['./request-ticket.component.css']
})
export class RequestTicketComponent implements OnInit {
  reimbTicket = new Array <Reimbursements>();

  constructor(private httpClient:HttpClient) { }

  ngOnInit() {
    this.viewReimbursementsTickets();
  }

  viewReimbursementsTickets(): void {
    this.httpClient.get('http://localhost:8080/Chats/request', {
        observe: 'response'
      }).pipe(map(response => response.body as Array <Reimbursements>))
      .subscribe(response => {
        response.forEach(element => {
          this.reimbTicket.push(element);
        })
        }, err => {
        });
  }
}
