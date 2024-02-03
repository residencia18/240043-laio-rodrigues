import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RotaJreaderComponent } from './rota-jreader.component';

describe('RotaJreaderComponent', () => {
  let component: RotaJreaderComponent;
  let fixture: ComponentFixture<RotaJreaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RotaJreaderComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RotaJreaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
