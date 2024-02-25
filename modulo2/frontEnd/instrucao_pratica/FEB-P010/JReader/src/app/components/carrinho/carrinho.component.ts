import { Component } from '@angular/core';
import { ListService } from '../../services/list.service';
import { Veiculo } from '../../Veiculo';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrl: './carrinho.component.css'
})
export class CarrinhoComponent {
  constructor(private listService: ListService){}

  veiculos: Veiculo[] = [];

  ngOnInit(){
    this.listService.listaVeiculos.subscribe(veiculos => {
      this.veiculos = veiculos;
    })
  }

}
