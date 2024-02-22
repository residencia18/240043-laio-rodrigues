import { Component, Input } from '@angular/core';
import { ListService } from './services/list.service';
import { Veiculo } from './Veiculo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  constructor(private listService: ListService) {}

  title = 'JReader';

  arquivoLido: boolean = false;

  ngOnInit() {
    this.arquivoLido = this.listService.received;
    this.selectedNames = [];
    this.selectedType = '';
  }

  selectedType: string = '';
  selectedNames: string[] = [];
  onTipoSelecionado() {
    this.selectedType = this.listService.type;
    this.selectedNames = this.listService.names;
    this.veiculoSelecionado = false;
    this.dadosSelecionado = false;
  }

  veiculoSelecionado: boolean = false;

  onVeiculoSelecionado() {
    this.veiculoSelecionado = !this.veiculoSelecionado;
    this.dadosSelecionado = false;
  }

  dadosSelecionado: boolean = false;
  onDadoSelecionado() {
    this.dadosSelecionado = !this.dadosSelecionado;
  }
}
