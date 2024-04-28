import { Directive } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from '@angular/forms';

@Directive({
  selector: '[maiorIdadeValidator]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: MaiorDeIdadeDirective,
    multi: true
  }]
})
export class MaiorDeIdadeDirective implements Validator{

  constructor() { }
  validate(control: AbstractControl<any, any>): ValidationErrors | null {
    const dataNascimento = control.value
    const anoNascimento = new Date(dataNascimento).getFullYear()
    const anoNascMais = anoNascimento + 18
    const anoAtual = new Date().getFullYear()

    const ehMaior = anoNascMais <= anoAtual

    return ehMaior ? null : { 'maiorIdadeValidator': true };
  }

}
