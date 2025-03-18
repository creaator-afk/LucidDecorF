import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchForServicesComponent } from './search-for-services.component';

describe('SearchForServicesComponent', () => {
  let component: SearchForServicesComponent;
  let fixture: ComponentFixture<SearchForServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SearchForServicesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchForServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
