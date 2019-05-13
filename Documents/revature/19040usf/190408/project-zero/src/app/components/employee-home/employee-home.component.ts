import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-home',
  templateUrl: './employee-home.component.html',
  styleUrls: ['./employee-home.component.css']
})
export class EmployeeHomeComponent implements OnInit {

  splitCache = sessionStorage.getItem('cache').split(' ');
  name = this.splitCache[2] + ' ' + this.splitCache[3];
  userId = this.splitCache[0];
  role_id = this.splitCache[4];

  constructor(private router: Router) { }

  ngOnInit() {
  }

  managerValid(): boolean {
    return this.role_id === '1';
  }

  pastTickets() {
    this.router.navigateByUrl('requestPastTickets');
  }

  viewAllTickets() {
    this.router.navigateByUrl('requestAllTickets');
  }

  submitReimbursements() {
    this.router.navigateByUrl('submitTickets');
  }

  updateReimbursements(){
    this.router.navigateByUrl('update');
  }
}
