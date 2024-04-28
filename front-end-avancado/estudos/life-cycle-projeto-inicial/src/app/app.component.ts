import { Component, DoCheck, OnInit } from '@angular/core';
import { Item } from './interfaces/iItem';
import { ListaDeCompraService } from './service/lista-de-compra.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit, DoCheck {
  title = 'app-lista-de-compras';

  listaDeCompra!: Array<Item>;
  itemParaEditar!: Item;

  constructor(private service: ListaDeCompraService) {}

  ngOnInit(): void {
    this.listaDeCompra = this.service.getListaDeCompra();
  }

  editarItem(item: Item) {
    this.itemParaEditar = item;
  }

  ngDoCheck(): void {
    // this.service.atualizarLocalStorage();
  }

  deletarItem(id: number){
    const index = this.listaDeCompra.findIndex(item => {
      return item.id === id;
    })
    this.service.deleteItem(index);

  }

  limparLista(){
    if(!this.listaDeCompra.length){
      alert("Não há itens na lista!")
      return
    }

    if(confirm("Deseja apagar todos os itens da lista?")){
      this.listaDeCompra = [];
      this.service.limparStorage()
    }
  }
}
