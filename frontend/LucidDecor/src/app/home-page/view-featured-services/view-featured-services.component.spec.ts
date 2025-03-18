import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewFeaturedServicesComponent } from './view-featured-services.component';

describe('ViewFeaturedServicesComponent', () => {
  let component: ViewFeaturedServicesComponent;
  let fixture: ComponentFixture<ViewFeaturedServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewFeaturedServicesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewFeaturedServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
