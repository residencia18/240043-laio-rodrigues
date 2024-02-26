import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css'
})
export class FormularioComponent {
  formulario: FormGroup;
  listaProfissoes: string[] = ['Engenheiro', 'Médico', 'Professor', 'Advogado', 'Programador'];


  constructor() {
    this.formulario = new FormGroup({
      usuario: new FormControl('', [Validators.required, Validators.maxLength(12)]),
      senha: new FormControl('', [Validators.required, Validators.minLength(4), Validators.pattern(/^(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]+$/)]),
      email: new FormControl('', [Validators.required, Validators.email]),
      nome: new FormControl('', [Validators.required, Validators.pattern(/^(\w+\s+\w+)$/)]),
      telefone: new FormControl('', [Validators.required, Validators.pattern(/^\(?(\d{2})\)?[-. ]?(\d{4,5})[-. ]?(\d{4})$/)]),
      endereco: new FormControl('', [Validators.required, Validators.minLength(5)]),
      nascimento: new FormControl('', [Validators.required, this.dataNascimentoValidator]),
      genero: new FormControl('', [Validators.required]),
      profissao: new FormControl('', [Validators.required]),
    });
  }

  dataNascimentoValidator(control: FormControl): { [s: string]: boolean } | null {
    if (!control.value) return null; // Se não houver valor, considera válido
    const dataNascimento = new Date(control.value);
    const idade = new Date().getFullYear() - dataNascimento.getFullYear();
    if (idade < 18) {
      return { 'menorDeIdade': true };
    }
    return null;
  }

  onSubmit(){
    if(this.formulario.invalid){
      console.log("INVALIDO")
      return;
    }

    const dadosFormulario = {
      usuario: this.formulario.get('usuario')?.value,
      senha: this.formulario.get('senha')?.value,
      email: this.formulario.get('email')?.value,
      nomeCompleto: this.formulario.get('nomeCompleto')?.value,
      telefone: this.formulario.get('telefone')?.value,
      endereco: this.formulario.get('endereco')?.value,
      nascimento: this.formulario.get('nascimento')?.value,
      genero: this.formulario.get('genero')?.value,
      profissao: this.formulario.get('profissao')?.value
    };

    console.log(dadosFormulario);
  }
}
