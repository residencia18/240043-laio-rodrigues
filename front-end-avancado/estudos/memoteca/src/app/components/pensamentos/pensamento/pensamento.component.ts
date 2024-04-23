import { Component, Input } from '@angular/core';
import { Pensamento } from '../pensamento';
import { PensamentoService } from '../../services/pensamento.service';

@Component({
  selector: 'app-pensamento',
  templateUrl: './pensamento.component.html',
  styleUrl: './pensamento.component.css',
})
export class PensamentoComponent {
  constructor(private service: PensamentoService){}

  @Input() pensamento: Pensamento = {
    id: '0',
    conteudo: 'I Love Angular',
    autoria: 'Nay',
    modelo: 'modelo3',
    favorito: false,
  };

  @Input() listaFavoritos: Pensamento[] = [];

  larguraPensamento(): string {
    return this.pensamento.conteudo.length >= 256
      ? 'pensamento-g'
      : 'pensamento-p';
  }

  mudarIconeFavorito(): string {
    if (this.pensamento.favorito) return 'ativo';
    return 'inativo';
  }

  atualizarFavoritos(){
    this.service.mudarFavorito(this.pensamento).subscribe(()=>{
      this.listaFavoritos.splice(this.listaFavoritos.indexOf(this.pensamento), 1)
    })
  }
}
