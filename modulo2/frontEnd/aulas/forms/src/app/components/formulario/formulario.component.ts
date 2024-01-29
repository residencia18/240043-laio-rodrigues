import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css'
})
export class FormularioComponent {
  exemploform: FormGroup;

  constructor(){
    this.exemploform = new FormGroup({
      'login': new FormControl(null, [Validators.required, Validators.minLength(4)]),
      'senha': new FormControl(null, [Validators.required, Validators.minLength(4), Validators.maxLength(10)])
    })
  }
}
