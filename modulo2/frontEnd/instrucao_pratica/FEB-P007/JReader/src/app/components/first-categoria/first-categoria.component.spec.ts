import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FirstCategoriaComponent } from './first-categoria.component';

describe('FirstCategoriaComponent', () => {
  let component: FirstCategoriaComponent;
  let fixture: ComponentFixture<FirstCategoriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FirstCategoriaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FirstCategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
