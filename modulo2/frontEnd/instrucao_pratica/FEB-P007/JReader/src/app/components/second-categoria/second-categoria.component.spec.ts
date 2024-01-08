import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecondCategoriaComponent } from './second-categoria.component';

describe('SecondCategoriaComponent', () => {
  let component: SecondCategoriaComponent;
  let fixture: ComponentFixture<SecondCategoriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SecondCategoriaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SecondCategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
