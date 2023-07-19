import { TestBed } from '@angular/core/testing';
import { FoodMenuServiceService } from './food-menu-service.service';


describe('FoodMenuServiceService', () => {
  let service: FoodMenuServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FoodMenuServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
