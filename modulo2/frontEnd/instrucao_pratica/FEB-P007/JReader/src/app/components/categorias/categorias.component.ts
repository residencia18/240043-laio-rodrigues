import { Component } from '@angular/core';

import { Veiculo } from '../../Veiculo';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrl: './categorias.component.css',
})
export class CategoriasComponent {
  json = [
    {
      Aviões: [
        {
          Name: 'Supermarine Spitire',
          Model: 'Mk V',
          Engine: 'Rolls-Royce Merlin',
          NumberOfPassengers: '1',
          Autonomia: '470 miles',
          Alcance: '1,135 miles',
          Teto: '36,500 ft',
        },
        {
          Name: 'P-51 Mustang',
          Model: 'D',
          Engine: 'Packard V-1650-7',
          NumberOfPassengers: '1',
          Autonomia: '1,650 miles',
          Alcance: '2,300 miles',
          Teto: '41,900 ft',
        },
        {
          Name: 'B-17 Flying Fortress',
          Model: 'G',
          Engine: 'Wright R-1820-97',
          NumberOfPassengers: '10',
          Autonomia: '2,000 miles',
          Alcance: '3,750 miles',
          Teto: '35,600 ft',
        },
      ],
    },
    {
      Carros: [
        {
          Name: 'Tesla Model S',
          Model: '2022',
          Engine: 'Electric',
          NumberOfPassengers: '5',
          Autonomia: '390 miles',
          Alcance: 'N/A',
          Teto: 'N/A',
        },
        {
          Name: 'Ford Mustang',
          Model: '2021',
          Engine: '5.0L Ti-VCT V8',
          NumberOfPassengers: '4',
          Autonomia: 'N/A',
          Alcance: 'N/A',
          Teto: 'N/A',
        },
        {
          Name: 'Chevrolet Camaro',
          Model: '2022',
          Engine: '6.2L Supercharged V8',
          NumberOfPassengers: '4',
          Autonomia: 'N/A',
          Alcance: 'N/A',
          Teto: 'N/A',
        },
      ],
    },
    {
      Barcos: [
        {
          Name: 'Ferretti Yachts',
          Model: '670',
          Engine: '2 x MAN V8-1000',
          NumberOfPassengers: '12',
          Autonomia: 'N/A',
          Alcance: 'N/A',
          Teto: 'N/A',
        },
        {
          Name: 'Azimut Grande',
          Model: '25 Metri',
          Engine: '2 x MAN V12-1800',
          NumberOfPassengers: '10',
          Autonomia: 'N/A',
          Alcance: 'N/A',
          Teto: 'N/A',
        },
        {
          Name: 'Sunseeker Predator',
          Model: '57',
          Engine: 'Twin Volvo Penta D13-900',
          NumberOfPassengers: '6',
          Autonomia: 'N/A',
          Alcance: 'N/A',
          Teto: 'N/A',
        },
      ],
    },
  ];

  received: boolean = true;

  onAbrirArquivo() {
    console.log('onAbrirArquivo');
  }

  avioes = [
    this.json.at(0)?.Aviões?.at(0),
    this.json.at(0)?.Aviões?.at(1),
    this.json.at(0)?.Aviões?.at(2),
  ];
  carros = [
    this.json.at(1)?.Carros?.at(0),
    this.json.at(1)?.Carros?.at(1),
    this.json.at(1)?.Carros?.at(2),
  ];
  barcos = [
    this.json.at(2)?.Barcos?.at(0),
    this.json.at(2)?.Barcos?.at(1),
    this.json.at(2)?.Barcos?.at(2),
  ];

  veiculos = [this.avioes, this.carros, this.barcos];
  names: string[] = [];
  type = '';
  idType = -1;
  veiculo: Veiculo | undefined = undefined;
  info: string|undefined = undefined;
  listVeiculos: Veiculo[] = [];

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
    let temp: Veiculo | undefined = this.veiculos.at(this.idType)!.at(index);
    this.info = undefined;
    if (temp != undefined) {
      this.veiculo = temp;
    }
  }

  onCategoriaSelecionada(i: number) {
    this.names.splice(0, 3);
    this.idType = i;
    this.veiculos.at(i)!.map((item) => {
      this.names.push(item!.Name);
    });
  }

  onTipoSelecionado(s: string) {
    this.type = s;
    this.veiculo = undefined;
  }
}
