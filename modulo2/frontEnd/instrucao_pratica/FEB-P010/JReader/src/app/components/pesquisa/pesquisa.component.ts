import { Component, Output, EventEmitter } from '@angular/core';
import { ListService } from '../../services/list.service';

@Component({
  selector: 'app-pesquisa',
  templateUrl: './pesquisa.component.html',
  styleUrl: './pesquisa.component.css',
})
export class PesquisaComponent {

  constructor( private listService: ListService) {}
  @Output() abrirArquivo: EventEmitter<any> = new EventEmitter();
  name: string = '';

  click() {
    this.listService.onBusca(this.name);
    this.abrirArquivo.emit();
  }
}
