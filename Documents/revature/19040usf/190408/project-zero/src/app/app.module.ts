import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { RequestTicketComponent } from './components/request-ticket/request-ticket.component';
import { UserComponent } from './components/user/user.component';
import { RequestAllEmployeeTicketComponent } from './components/request-all-employee-ticket/request-all-employee-ticket.component';
import { EmployeeHomeComponent } from './components/employee-home/employee-home.component';
import { SubmitTicketComponent } from './components/submit-ticket/submit-ticket.component';
import { SubmitTicketService } from 'src/app/services/submit-ticket.service';
import { UpdateComponent } from './components/update/update.component';
@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    RequestTicketComponent,
    RequestAllEmployeeTicketComponent,
    EmployeeHomeComponent,
    SubmitTicketComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService, SubmitTicketService],
  bootstrap: [AppComponent]
})
export class AppModule { }
