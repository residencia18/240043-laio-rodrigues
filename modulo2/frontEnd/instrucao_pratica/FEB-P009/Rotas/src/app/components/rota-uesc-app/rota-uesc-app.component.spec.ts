import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RotaUescAppComponent } from './rota-uesc-app.component';

describe('RotaUescAppComponent', () => {
  let component: RotaUescAppComponent;
  let fixture: ComponentFixture<RotaUescAppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RotaUescAppComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RotaUescAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
