import { Pensamento } from './../pensamento';
import { Component } from '@angular/core';
import { PensamentoService } from '../../services/pensamento.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-editar-pensamento',
  templateUrl: './editar-pensamento.component.html',
  styleUrl: './editar-pensamento.component.css',
})
export class EditarPensamentoComponent {
  formulario!: FormGroup;

  constructor(
    private service: PensamentoService,
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder
  ) {}
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.service.buscaPorId(id!).subscribe((pensamento) => {
      this.formulario = this.formBuilder.group({
        id: [pensamento.id],
        conteudo: [
          pensamento.conteudo,
          Validators.compose([
            Validators.required,
          Validators.pattern(/(.|\s)*\S(.|\s)*/),
        ]),
      ],
      autoria: [
        pensamento.autoria,
        Validators.compose([Validators.required, Validators.minLength(3)]),
      ],
      modelo: [pensamento.modelo],
      favorito: [pensamento.favorito]
    });
  });
}

  editarPensamento() {
    if (this.formulario.valid) {
      this.service.editar(this.formulario.value).subscribe(() => {
        this.router.navigate(['/']);
      });
    }
  }

  cancelar() {
    this.router.navigate(['/']);
  }

  habilitarBotao(): string {
    if (this.formulario.valid) return 'botao';
    return 'botao__desabilitado';
  }
}
