import { ActivatedRoute, Router } from '@angular/router';
import { PensamentoService } from '../../services/pensamento.service';
import { Pensamento } from './../pensamento';
import { Component } from '@angular/core';

@Component({
  selector: 'app-excluir-pensamento',
  templateUrl: './excluir-pensamento.component.html',
  styleUrl: './excluir-pensamento.component.css'
})
export class ExcluirPensamentoComponent {
  pensamento: Pensamento = {
    id: '0',
    conteudo: '',
    autoria: '',
    modelo: '',
    favorito: false
  }

  constructor(
    private servie: PensamentoService,
    private router: Router,
    private route: ActivatedRoute
  ){}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');

    this.servie.buscaPorId(id!).subscribe(pensamento => {
      this.pensamento = pensamento;
    })
  }

  excluirPensamento(){
    if(this.pensamento.id){
      this.servie.excluir(this.pensamento.id).subscribe(() => {
        this.router.navigate(['/']);
      })
    }
  }

  cancelar(){
    this.router.navigate(['/'])
  }
}
