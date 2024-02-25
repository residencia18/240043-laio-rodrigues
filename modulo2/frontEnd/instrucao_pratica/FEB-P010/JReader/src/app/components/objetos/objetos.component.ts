import { Component, EventEmitter, OnInit } from '@angular/core';
import { Veiculo } from '../../Veiculo';
import { ListService } from '../../services/list.service';

@Component({
  selector: 'app-objetos',
  templateUrl: './objetos.component.html',
  styleUrl: './objetos.component.css'
})
export class ObjetosComponent implements OnInit {
  constructor(private listService: ListService) {}

  show: boolean = false;
  veiculos: Veiculo[] = [];
  tipo: string = '';

  ngOnInit() {
    this.listService.tipoVeiculoSelecionado$.subscribe(tipo => {
      this.tipo = tipo;
    });
    this.listService.veiculos.subscribe(veiculos => {
      this.veiculos = veiculos;
    })
  }

  onClick(index: number){
    this.listService.selecionarveiculo(index);
  }
}
