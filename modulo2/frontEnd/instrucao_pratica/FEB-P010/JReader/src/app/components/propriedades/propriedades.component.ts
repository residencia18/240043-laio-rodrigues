import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ListService } from '../../services/list.service';

@Component({
  selector: 'app-propriedades',
  templateUrl: './propriedades.component.html',
  styleUrl: './propriedades.component.css',
})
export class PropriedadesComponent implements OnInit {
  constructor(private listService: ListService) {}

  name: string = '';
  veiculo: any = {};

  ngOnInit(){
    this.listService.veiculoSelecionado.subscribe(veiculo => {
      this.veiculo = veiculo;
      this.name = veiculo.Name;
    })
    console.log(this.name);
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
    this.listService.selecionarPropriedade(index);
  }
}
