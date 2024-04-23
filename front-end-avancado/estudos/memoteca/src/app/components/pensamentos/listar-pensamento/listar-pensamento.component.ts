import { Component } from '@angular/core';
import { Pensamento } from '../pensamento';
import { PensamentoService } from '../../services/pensamento.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-pensamento',
  templateUrl: './listar-pensamento.component.html',
  styleUrl: './listar-pensamento.component.css',
})
export class ListarPensamentoComponent {
  listaPensamentos: Pensamento[] = [];
  haMaisPensamentos: boolean = true;

  paginaAtual: number = 1;
  filtro: string = '';
  favorito: boolean = false;
  listaFavoritos: Pensamento[] = [];
  titulo: string = 'Meu Mural'

  constructor(
    private service: PensamentoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.service
      .listar(this.paginaAtual, this.filtro, this.favorito)
      .subscribe((lista) => {
        this.listaPensamentos = lista;
      });
  }

  carregarMaisPensamentos() {
    this.service
      .listar(++this.paginaAtual, this.filtro, this.favorito)
      .subscribe((lista) => {
        this.listaPensamentos.push(...lista);
        if (!lista.length) {
          this.haMaisPensamentos = false;
        }
      });
  }

  pesquisarPensamentos() {
    this.haMaisPensamentos = true;
    this.paginaAtual = 1;
    this.service
      .listar(this.paginaAtual, this.filtro, this.favorito)
      .subscribe((lista) => {
        this.listaPensamentos = lista;
      });
  }

  listarFavoritos() {
    this.titulo = 'Meus Favoritos'
    this.haMaisPensamentos = true;
    this.paginaAtual = 1;
    this.favorito = true;
    this.service
      .listar(this.paginaAtual, this.filtro, this.favorito)
      .subscribe((lista) => {
        this.listaPensamentos = lista;
        this.listaFavoritos = lista;
      });
  }

  recarregarComponente(){
    this.favorito = false
    this.paginaAtual = 1

    this.router.navigate([this.router.url])
  }
}
