import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LastCategoriaComponent } from './last-categoria.component';

describe('LastCategoriaComponent', () => {
  let component: LastCategoriaComponent;
  let fixture: ComponentFixture<LastCategoriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LastCategoriaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LastCategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
