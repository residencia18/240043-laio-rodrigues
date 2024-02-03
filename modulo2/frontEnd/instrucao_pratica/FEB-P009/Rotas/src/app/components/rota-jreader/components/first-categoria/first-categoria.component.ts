import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-first-categoria',
  templateUrl: './first-categoria.component.html',
  styleUrl: './first-categoria.component.css'
})
export class FirstCategoriaComponent {
  @Output() categoriaSelecionada = new EventEmitter<number>();
  @Output() tipoSelecionado = new EventEmitter<string>();
  select(selected: number, type: string){
    this.categoriaSelecionada.emit(selected);
    this.tipoSelecionado.emit(type)
  }

}
