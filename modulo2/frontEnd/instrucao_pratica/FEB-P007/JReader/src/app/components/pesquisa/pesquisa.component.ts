import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-pesquisa',
  templateUrl: './pesquisa.component.html',
  styleUrl: './pesquisa.component.css'
})

export class PesquisaComponent {
  @Output() abrirArquivo: EventEmitter<any> = new EventEmitter();

  click(){
    this.abrirArquivo.emit();
  }
}
