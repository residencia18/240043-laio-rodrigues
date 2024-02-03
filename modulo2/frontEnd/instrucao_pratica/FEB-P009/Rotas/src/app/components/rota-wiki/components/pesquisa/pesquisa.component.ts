import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-pesquisa',
  templateUrl: './pesquisa.component.html',
  styleUrl: './pesquisa.component.css'
})
export class PesquisaComponent {
  @Output() pesquisa: EventEmitter<any> = new EventEmitter();
  name: string = "";

  click(){
    this.pesquisa.emit(this.name);
  }
}
