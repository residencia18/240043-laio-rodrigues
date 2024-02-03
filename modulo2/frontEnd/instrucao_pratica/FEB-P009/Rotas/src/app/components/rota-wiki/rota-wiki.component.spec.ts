import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RotaWikiComponent } from './rota-wiki.component';

describe('RotaWikiComponent', () => {
  let component: RotaWikiComponent;
  let fixture: ComponentFixture<RotaWikiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RotaWikiComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RotaWikiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
