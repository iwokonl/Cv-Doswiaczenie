import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployessListComponent } from './employess-list.component';

describe('EmployessListComponent', () => {
  let component: EmployessListComponent;
  let fixture: ComponentFixture<EmployessListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployessListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployessListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
