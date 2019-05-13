import { Component, OnInit } from '@angular/core';
import { Reimbursements } from 'src/app/Reimbursements';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-request-all-employee-ticket',
  templateUrl: './request-all-employee-ticket.component.html',
  styleUrls: ['./request-all-employee-ticket.component.css']
})
export class RequestAllEmployeeTicketComponent implements OnInit {
  reimbAllTicket = new Array <Reimbursements>();

  constructor(private router:Router, private httpClient:HttpClient) { }

  ngOnInit() {
  this.viewAllReimbursementsTickets();
  }
  viewAllReimbursementsTickets(): void {
    this.httpClient.get('http://localhost:8080/Chats/manager', {
        observe: 'response'
      }).pipe(map(response => response.body as Array <Reimbursements>))
      .subscribe(response => {
        response.forEach(element => {
          this.reimbAllTicket.push(element);
        })
        }, err => {
        });
  }

  employeePage() {
    this.router.navigateByUrl('employee');
  }

}
