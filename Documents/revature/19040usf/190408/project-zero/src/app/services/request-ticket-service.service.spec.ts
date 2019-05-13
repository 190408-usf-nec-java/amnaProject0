import { TestBed } from '@angular/core/testing';

import { RequestTicketServiceService } from './request-ticket-service.service';

describe('RequestTicketServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RequestTicketServiceService = TestBed.get(RequestTicketServiceService);
    expect(service).toBeTruthy();
  });
});
