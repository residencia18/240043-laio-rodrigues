import { Component, EventEmitter, Output } from '@angular/core';
import { ListService } from '../../services/list.service';

@Component({
  selector: 'app-classes',
  templateUrl: './classes.component.html',
  styleUrl: './classes.component.css',
})
export class ClassesComponent {
  constructor(private listService: ListService) {}
  @Output() classeSelecionada: EventEmitter<any> = new EventEmitter();

  onClick(selecionado: string, index: number){
    this.listService.onCategoriaSelecionada(index);
    this.listService.onTipoSelecionado(selecionado);
    this.classeSelecionada.emit();
  }
}
