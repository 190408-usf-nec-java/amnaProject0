import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestAllEmployeeTicketComponent } from './request-all-employee-ticket.component';

describe('RequestAllEmployeeTicketComponent', () => {
  let component: RequestAllEmployeeTicketComponent;
  let fixture: ComponentFixture<RequestAllEmployeeTicketComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestAllEmployeeTicketComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestAllEmployeeTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
