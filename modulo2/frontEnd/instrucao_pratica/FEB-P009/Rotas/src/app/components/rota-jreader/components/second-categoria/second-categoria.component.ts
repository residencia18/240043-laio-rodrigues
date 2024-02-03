import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-second-categoria',
  templateUrl: './second-categoria.component.html',
  styleUrl: './second-categoria.component.css'
})
export class SecondCategoriaComponent {
  @Input() selectedNames: string[] = [];
  @Input() selectedType: string = "";
  @Output() nomeSelecionado = new EventEmitter();

  select(nome: number): void {
    this.nomeSelecionado.emit(nome);
  }
}
