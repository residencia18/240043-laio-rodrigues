import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Veiculo } from '../../Veiculo';
import { ListService } from '../../services/list.service';

@Component({
  selector: 'app-objetos',
  templateUrl: './objetos.component.html',
  styleUrl: './objetos.component.css'
})
export class ObjetosComponent {
  constructor(private listService: ListService) {}

  @Output() veiculoSelecionado = new EventEmitter();
  @Input() veiculos: string[] = [];
  @Input() tipo: string = '';

  onClick(index: number){
    this.listService.onNomeSelecionado(index);
    this.veiculoSelecionado.emit();
  }
}
