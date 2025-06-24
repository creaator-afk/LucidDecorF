import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnterCredentialsComponent } from './enter-credentials.component';

describe('EnterCredentialsComponent', () => {
  let component: EnterCredentialsComponent;
  let fixture: ComponentFixture<EnterCredentialsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EnterCredentialsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnterCredentialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
