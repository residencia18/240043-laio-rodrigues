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
    this.name = this.listService.veiculo?.Name;
    this.info = this.listService.info;
  }

  onClick(){
    this.listService.onAdicionar();
  }
}
