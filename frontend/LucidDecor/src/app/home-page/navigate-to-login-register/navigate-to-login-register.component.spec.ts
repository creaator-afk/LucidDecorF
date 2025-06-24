import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigateToLoginRegisterComponent } from './navigate-to-login-register.component';

describe('NavigateToLoginRegisterComponent', () => {
  let component: NavigateToLoginRegisterComponent;
  let fixture: ComponentFixture<NavigateToLoginRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NavigateToLoginRegisterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavigateToLoginRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
