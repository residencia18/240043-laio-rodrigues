import { Component } from '@angular/core';
import { ListService } from '../../services/list.service';

@Component({
  selector: 'app-valor-propriedade',
  templateUrl: './valor-propriedade.component.html',
  styleUrl: './valor-propriedade.component.css'
})
export class ValorPropriedadeComponent {
  constructor(private listService: ListService){}

  name: string|undefined = '';
  info: string|undefined = '';


  ngOnInit(){
    this.listService.veiculoSelecionado.subscribe(veiculo => {
      this.name = veiculo.Name;
    })
    this.listService.propriedadeSelecionada.subscribe(propriedade => {
      this.info = propriedade;
    })
  }

  onClick(){
    let temp;
    this.listService.veiculoSelecionado.subscribe(veiculo => {
      temp = veiculo;
    })
    this.listService.adicionarVeiculo(temp!);
  }
}
