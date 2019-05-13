import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { SubmitTicketService } from 'src/app/services/submit-ticket.service';
@Component({
  selector: 'app-submit-ticket',
  templateUrl: './submit-ticket.component.html',
  styleUrls: ['./submit-ticket.component.css']
})
export class SubmitTicketComponent implements OnInit {
 
  splitCache = sessionStorage.getItem('cache').split(' ');
  name = this.splitCache[2] + ' ' + this.splitCache[3];
  UserId = this.splitCache[0];
  role_id = this.splitCache[4];
  amount=0;
  description='';
  type_id=0;
  status = 0;



  submitArray;

  SubmitResponse: Subscription;

  lastStatus = 200;

  constructor(private submitTicketService: SubmitTicketService, private router: Router) { }

  ngOnInit() {
    this.SubmitResponse = this.submitTicketService.$SubmitStatus.subscribe(status => {
      if (status === 200) {
        this.router.navigateByUrl('employee');
        console.log(this.submitArray);
      } else {
        this.lastStatus = status;
      }
    })}
  submit() {
    console.log('submitted');
    this.submitTicketService.SubmitNew(this.amount, this.description, this.type_id, this.status);
    this.router.navigateByUrl('employee');
  }
}
