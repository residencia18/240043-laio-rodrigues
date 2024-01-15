import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-last-categoria',
  templateUrl: './last-categoria.component.html',
  styleUrl: './last-categoria.component.css'
})
export class LastCategoriaComponent {
  @Input() showName: string|undefined = undefined;
  @Input() showInfo: string|undefined = undefined;
  @Output() adicionar = new EventEmitter();

  add(){
    this.adicionar.emit();
  }
}
