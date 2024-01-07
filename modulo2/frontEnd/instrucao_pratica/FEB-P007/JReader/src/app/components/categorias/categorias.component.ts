import { Component } from '@angular/core';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrl: './categorias.component.css',
})
export class CategoriasComponent {
  json = [
    {
      Type: "Aviões", Dados: [
        {
          Name: 'Supermarine Spitire',
          Model: 'Mk V',
          Engine: 'Rolls-Royce Merlin',
          NumberOfPassengers: 1,
          Autonomia: '470 miles',
          Alcance: '1,135 miles',
          Teto: '36,500 ft',
        },
        {
          Name: 'P-51 Mustang',
          Model: 'D',
          Engine: 'Packard V-1650-7',
          NumberOfPassengers: 1,
          Autonomia: '1,650 miles',
          Alcance: '2,300 miles',
          Teto: '41,900 ft',
        },
        {
          Name: 'B-17 Flying Fortress',
          Model: 'G',
          Engine: 'Wright R-1820-97',
          NumberOfPassengers: 10,
          Autonomia: '2,000 miles',
          Alcance: '3,750 miles',
          Teto: '35,600 ft',
        },
      ],
    },
    {
      Type: "Carros", Dados: [
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
      Type: "Barcos", Dados: [
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

  tipos = this.json.map((obj)=>{
    return obj.Type;
  })

  showType = this.tipos.at(0);
  preDados = this.json.find((obj)=>{
    return obj.Type === this.showType;
  })
  dados = this.preDados?.Dados;

  nomes = this.dados?.map((obj)=>{
    return obj.Name;
  })

  showName = this.nomes?.at(0);

  propriedade = "";
  veiculo = this.dados?.find((obj)=>{
    return obj.Name === this.showName;
  })

  test(){

  }

  sName(){
    if(this.veiculo != undefined)
      this.propriedade = this.veiculo.Name;
    console.log('ok')
  }

  sModel(){
    if(this.veiculo!= undefined)
      this.propriedade = this.veiculo.Model;
  }

  sEngine(){
    if(this.veiculo!= undefined)
      this.propriedade = this.veiculo.Engine;
  }

  sAutonomia(){
    if(this.veiculo!= undefined)
      this.propriedade = this.veiculo.Autonomia;
  }

  sAlcance(){
    if(this.veiculo!= undefined)
      this.propriedade = this.veiculo.Alcance;
  }

  sTeto(){
    if(this.veiculo!= undefined)
      this.propriedade = this.veiculo.Teto
  }

  sNumberOfPassengers(){
    if(this.veiculo!= undefined)
      this.propriedade = this.veiculo.NumberOfPassengers.toString();
  }
}
