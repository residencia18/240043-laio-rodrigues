import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-third-categoria',
  templateUrl: './third-categoria.component.html',
  styleUrl: './third-categoria.component.css',
})
export class ThirdCategoriaComponent {
  @Input() showName: string | undefined = '';
  @Input() type: string = '';
  @Output() dadoSelecionado = new EventEmitter();

  select(tipo: number): void {
    this.dadoSelecionado.emit(tipo);
  }

  listDados = [
    'Name',
    'Model',
    'Engine',
    'NumberOfPassengers',
    'Autonomia',
    'Alcance',
    'Teto',
  ];
}
