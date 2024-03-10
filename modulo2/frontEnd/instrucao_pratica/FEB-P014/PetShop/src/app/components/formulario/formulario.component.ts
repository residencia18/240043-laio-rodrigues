import { Component } from '@angular/core';
import { AtendimentoService } from '../../services/atendimento.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Atendimento } from '../../Model/Atendimento';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css',
})
export class FormularioComponent {
  form: FormGroup;
  editMode = false;
  appointmentId = '';
  atendimentoSelecionado: Atendimento = {} as Atendimento;
  animais: string[] = [
    '',
    'Cachorro',
    'Gato',
    'Coelho',
    'Girafa',
    'Tartaruga',
    'Pato',
    'Cavalo',
  ];

  constructor(
    private dataService: AtendimentoService,
    private route: ActivatedRoute,
    private rotas: Router
  ) {
    this.form = new FormGroup({
      dt_atendimento: new FormControl(null, [Validators.required]),
      dono: new FormControl(null, [Validators.required]),
      pet_nome: new FormControl(null, [Validators.required]),
      pet_tipo: new FormControl(null, [Validators.required]),
      pet_raca: new FormControl(null, [Validators.required]),
      detalhes: new FormControl(null),
    });
  }

  ngOnInit(): void {
    this.route.url.subscribe((params) => {
      if (params[0].path === 'editar') {
        this.editMode = true;
        this.appointmentId = params[1].path;
        this.dataService
          .obterAtendimento(this.appointmentId)
          .subscribe((value) => {
            this.form.setValue({
              dt_atendimento: value.dt_atendimento,
              dono: value.dono,
              pet_nome: value.pet_nome,
              pet_tipo: value.pet_tipo,
              pet_raca: value.pet_raca,
              detalhes: value.detalhes,
            });
          });
      }
    });
  }

  onSubmit() {
    if (this.form.invalid || this.form.get('pet_tipo')?.value === '') {
      alert('Preencha todos os campos!');
      return;
    }
    const dados = this.form.value;
    if (this.editMode) {
      dados.id = this.appointmentId;
      this.editMode = false;
      this.appointmentId = '';
      this.dataService.atualizarAtendimento(dados).subscribe({
        next: (response) => {
          this.form.reset();
          this.rotas.navigate(['/lista']);
          alert('Atendimento cadastrado!');
        },
        error: (error) => {
          console.log(error);
          alert('Não foi possível cadastrar o atendimento!');
        },
      });
    } else {
      this.dataService.adicionarAtendimento(dados);
      this.form.reset();
      alert('Atendimento cadastrado!');
    }
  }
}
