import { TestBed } from '@angular/core/testing';

import { RequestAllTicketsService } from './request-all-tickets.service';

describe('RequestAllTicketsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RequestAllTicketsService = TestBed.get(RequestAllTicketsService);
    expect(service).toBeTruthy();
  });
});
