import { Item } from 'src/app/interfaces/iItem';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ListaDeCompraService {

  private listaDeCompra: Item[] = []

  constructor() {
    this.listaDeCompra = JSON.parse(localStorage.getItem('itens') || '[]')
  }

  getListaDeCompra(){
    return this.listaDeCompra;
  }

  criarItem(nomeDoItem: string){
    const id = this.listaDeCompra.length + 1
    const item: Item = {
      id: id,
      nome: nomeDoItem,
      data: new Date().toLocaleString('pt-BR'),
      comprado: false
    }
    return item
  }

  adicionarItemNaLista(nomeDoItem: string){
    const item = this.criarItem(nomeDoItem)
    this.listaDeCompra.push(item)
    this.atualizarLocalStorage()
  }

  editarItemNaLista(itemAntigo: Item, nomeNovo: string){
    const itemEditado: Item = {
      id: itemAntigo.id,
      nome: nomeNovo,
      data: itemAntigo.data,
      comprado: itemAntigo.comprado
    }
    const id = itemAntigo.id
    this.listaDeCompra.splice(Number(id)-1, 1, itemEditado)
    this.atualizarLocalStorage()
  }

  atualizarLocalStorage(){
    localStorage.setItem('itens', JSON.stringify(this.listaDeCompra))
  }

  deleteItem(index: number){
    this.listaDeCompra.splice(index-1, 1)
    this.atualizarLocalStorage()
  }

  limparStorage(){
    this.listaDeCompra = []
    localStorage.removeItem('itens')
    this.atualizarLocalStorage()
  }
}
