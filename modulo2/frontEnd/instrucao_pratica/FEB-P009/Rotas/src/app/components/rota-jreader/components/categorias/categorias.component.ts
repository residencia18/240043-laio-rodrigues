import { Component } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Veiculo } from '../../Veiculo';
import { Categorias } from '../../Categorias';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrl: './categorias.component.css',
})
export class CategoriasComponent {
  constructor(private http: HttpClient) { }

  json: Veiculo[][] = [];

  caminho: string = "";
  received: boolean = false;

  names: string[] = [];
  type = '';
  idType = -1;
  veiculo: Veiculo | undefined = undefined;
  info: string|undefined = undefined;
  listVeiculos: Veiculo[] = [];

  onAbrirArquivo(name: string) {
    this.caminho = name;
    for(let i = 0; i < 10000; i++)
      console.log(name);
    this.carregarArquivoJSON();
  }

  onAdicionar(){
    if(this.veiculo != undefined){
      if(!this.listVeiculos.some(veiculo => veiculo.Name === this.veiculo?.Name))
        this.listVeiculos.push(this.veiculo);
    }
  }

  onDadoSelecionado(index: number): void {
    switch (index) {
      case 0:
        this.info = this.veiculo?.Name;
        break;
      case 1:
        this.info = this.veiculo?.Model;
        break;
      case 2:
        this.info = this.veiculo?.Engine;
        break;
      case 3:
        this.info = this.veiculo?.NumberOfPassengers;
        break;
      case 4:
        this.info = this.veiculo?.Autonomia;
        break;
      case 5:
        this.info = this.veiculo?.Alcance;
        break;
      case 6:
        this.info = this.veiculo?.Teto;
        break;
      default:
        break;
    }
  }

  onNomeSelecionado(index: number): void {
    let temp: Veiculo | undefined = this.json[this.idType][index];
    this.info = undefined;
    if (temp != undefined) {
      this.veiculo = temp;
    }
  }

  onCategoriaSelecionada(i: number) {
    this.names.splice(0, 3);
    this.idType = i;
    this.json[i].map(item=>{
      this.names.push(item.Name)
    })
  }

  onTipoSelecionado(s: string) {
    this.type = s;
    this.veiculo = undefined;
  }

  carregarArquivoJSON(){
    this.http.get<Categorias>("assets\\" + this.caminho).subscribe(json => {
      this.json = [json.Avioes, json.Carros, json.Barcos]
      this.received = true;
    });
  }
}
