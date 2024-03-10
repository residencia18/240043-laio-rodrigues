import { Component, Input } from '@angular/core';
import { AtendimentoService } from '../../services/atendimento.service';
import { Atendimento } from '../../Model/Atendimento';

@Component({
  selector: 'app-detalhes',
  templateUrl: './detalhes.component.html',
  styleUrl: './detalhes.component.css',
})
export class DetalhesComponent {
  @Input() atendimentoID: string = '';
  atendimento: Atendimento = {} as Atendimento;

  constructor(private dataService: AtendimentoService) {}

  ngOnInit() {
    this.dataService.obterAtendimento(this.atendimentoID).subscribe({
      next: (response) => {
        this.atendimento = response;
        console.log(this.atendimento);
      },
      error: (error) => {
        console.log(error);
      },
    });
  }
}
