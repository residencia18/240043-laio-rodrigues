import { Component, EventEmitter, Output } from '@angular/core';
import { ListService } from '../../services/list.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-classes',
  templateUrl: './classes.component.html',
  styleUrl: './classes.component.css',
})
export class ClassesComponent {

  show: boolean = false;
  private subscription: Subscription;

  constructor(private listService: ListService) {
    this.subscription = this.listService.showClasses.subscribe(show => {
      this.show = show;
    })
  }

  onClick(selecionado: string){
    this.listService.selecionarTipoVeiculo(selecionado);
  }
}
