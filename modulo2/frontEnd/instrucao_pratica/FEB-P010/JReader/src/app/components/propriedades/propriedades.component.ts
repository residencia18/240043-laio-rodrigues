import { Component, EventEmitter, Output } from '@angular/core';
import { ListService } from '../../services/list.service';

@Component({
  selector: 'app-propriedades',
  templateUrl: './propriedades.component.html',
  styleUrl: './propriedades.component.css',
})
export class PropriedadesComponent {
  @Output() dadoSelecionado = new EventEmitter();
  constructor(private listService: ListService) {}

  name: string|undefined = '';
  ngOnInit(){
    this.name = this.listService.veiculo?.Name;
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

  onClick(index: number){
    this.listService.onDadoSelecionado(index);
    this.dadoSelecionado.emit();
  }
}
