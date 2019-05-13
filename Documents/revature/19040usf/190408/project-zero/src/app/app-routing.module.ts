import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './components/user/user.component';
import { EmployeeHomeComponent } from './components/employee-home/employee-home.component';
import { RequestAllEmployeeTicketComponent } from './components/request-all-employee-ticket/request-all-employee-ticket.component';
import { RequestTicketComponent } from './components/request-ticket/request-ticket.component';
import { SubmitTicketComponent } from './components/submit-ticket/submit-ticket.component';
import { UpdateComponent } from './components/update/update.component';


const routes: Routes = [
  {
    path: 'login',
    component: UserComponent
  }, {
    path: 'employee',
    component: EmployeeHomeComponent
  }, {
    path: 'requestAllTickets',
    component: RequestAllEmployeeTicketComponent
  }, {
    path: 'requestPastTickets',
    component: RequestTicketComponent
  }, {
    path: 'submitTickets',
    component: SubmitTicketComponent
  }, {
    path: 'update',
    component: UpdateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
