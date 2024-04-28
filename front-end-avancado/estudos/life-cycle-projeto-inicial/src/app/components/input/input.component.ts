import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Item } from 'src/app/interfaces/iItem';
import { ListaDeCompraService } from 'src/app/service/lista-de-compra.service';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css']
})
export class InputComponent implements OnInit, OnChanges {
  @Input() itemEditado!: Item

  editando = false
  textoBtn = 'Salvar item'

  valorItem!: string


  constructor(private service: ListaDeCompraService) { }

  ngOnInit(): void { }

  adicionarItem(){
    this.service.adicionarItemNaLista(this.valorItem)
    this.limparCampo()
  }

  limparCampo(){
    this.valorItem = ""
  }

  editarItem(){
    this.service.editarItemNaLista(this.itemEditado, this.valorItem)
    this.limparCampo()
    this.editando = false
    this.textoBtn = 'Salvar item'
  }

  ngOnChanges(changes: SimpleChanges): void {
    if(!changes['itemEditado'].isFirstChange()){
      this.editando = true
      this.textoBtn = 'Atualizar item'
      this.valorItem = this.itemEditado.nome
    }
  }


}
