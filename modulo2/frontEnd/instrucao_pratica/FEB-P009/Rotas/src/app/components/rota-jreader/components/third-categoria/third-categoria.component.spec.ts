import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThirdCategoriaComponent } from './third-categoria.component';

describe('ThirdCategoriaComponent', () => {
  let component: ThirdCategoriaComponent;
  let fixture: ComponentFixture<ThirdCategoriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ThirdCategoriaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ThirdCategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
