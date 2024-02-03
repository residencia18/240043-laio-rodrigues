import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-busca',
  templateUrl: './busca.component.html',
  styleUrl: './busca.component.css',
})
export class BuscaComponent {
  @Output() abrirArquivo: EventEmitter<any> = new EventEmitter();
  name: string = '';

  click() {
    console.log(this.name);
    this.abrirArquivo.emit(this.name);
  }
}
