import { Injectable, OnInit } from '@angular/core';
import { Veiculo } from '../Veiculo';
import { Categorias } from '../Categorias';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ListService {
  constructor(private http: HttpClient) {}

  private showSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(
    false
  );
  showClasses: Observable<boolean> = this.showSubject.asObservable();


  private tipoVeiculoSelecionadoSubject = new BehaviorSubject<string>('');
  tipoVeiculoSelecionado$ = this.tipoVeiculoSelecionadoSubject.asObservable();

  selecionarTipoVeiculo(tipo: string): void {
    this.tipoVeiculoSelecionadoSubject.next(tipo);
    this.getVeiculos(tipo);
  }


  private veiculosSubject = new BehaviorSubject<Veiculo[]>([]);
  veiculos = this.veiculosSubject.asObservable();

  getVeiculos(tipo: string){
    let veiculos: Veiculo[] = [];
    switch (tipo) {
      case 'Aviões':
        veiculos = this.json[0];
        break;
      case 'Carros':
        veiculos = this.json[1];
        break;
      case 'Barcos':
        veiculos = this.json[2];
        break;
      default:
        break;
    }
    this.veiculosSubject.next(veiculos);
  }


  private indexSelecionadoSubject = new BehaviorSubject<number>(-1);
  selecionado = this.indexSelecionadoSubject.asObservable();
  private veiculoSelecionadoSubject = new BehaviorSubject<any>({});
  veiculoSelecionado = this.veiculoSelecionadoSubject.asObservable();

  selecionarveiculo(index: number){
    this.indexSelecionadoSubject.next(index);
    let temp;
    this.veiculos.subscribe(veiculo => temp = veiculo[index]);
    this.setVeiculoSelecionado(temp!);
  }

  setVeiculoSelecionado(veiculo: Veiculo){
    this.veiculoSelecionadoSubject.next(veiculo);
  }


  private indexPropriedadeSelecionadaSubject = new BehaviorSubject<number>(-1);
  indexPropriedadeSelecionada = this.indexPropriedadeSelecionadaSubject.asObservable();
  private propriedadeSelecionadaSubject = new BehaviorSubject<string>('');
  propriedadeSelecionada = this.propriedadeSelecionadaSubject.asObservable();

  selecionarPropriedade(index: number){
    this.indexPropriedadeSelecionadaSubject.next(index);
    this.setPropriedadeSelecionada(index);
  }

  setPropriedadeSelecionada(index: number){
    let propriedade;
    switch(index){
      case 0:
        this.veiculoSelecionado.subscribe(veiculo => {
          propriedade = veiculo.Name;
        })
        break;
      case 1:
        this.veiculoSelecionado.subscribe((veiculo) => {
          propriedade = veiculo.Model;
        });
        break;
      case 2:
        this.veiculoSelecionado.subscribe((veiculo) => {
          propriedade = veiculo.Engine;
        });
        break;
      case 3:
        this.veiculoSelecionado.subscribe((veiculo) => {
          propriedade = veiculo.NumberOfPassengers;
        });
        break;
      case 4:
        this.veiculoSelecionado.subscribe((veiculo) => {
          propriedade = veiculo.Autonomia;
        });
        break;
      case 5:
        this.veiculoSelecionado.subscribe((veiculo) => {
          propriedade = veiculo.Alcance;
        });
        break;
      case 6:
        this.veiculoSelecionado.subscribe((veiculo) => {
          propriedade = veiculo.Teto;
        });
        break;
      default:
        break;
    }
    this.propriedadeSelecionadaSubject.next(propriedade!);
  }



  private listaVeiculosSubject = new BehaviorSubject<Veiculo[]>([]);
  listaVeiculos = this.listaVeiculosSubject.asObservable();

  adicionarVeiculo(veiculo: Veiculo) {
    const listaAtual = this.listaVeiculosSubject.value;

    if (!listaAtual.some((item) => veiculo.Name === item.Name))
        listaAtual.push(veiculo);

    this.listaVeiculosSubject.next(listaAtual);
  }



  json: Veiculo[][] = [];

  received(value: boolean): void {
    this.showSubject.next(value);
  }

  carregarArquivoJSON(caminho: string) {
    this.http.get<Categorias>('assets\\' + caminho).subscribe((json) => {
      this.json = [json.Avioes, json.Carros, json.Barcos];
      this.received(true);
    });
  }

  onAbrirArquivo(name: string): Observable<string> {
    this.carregarArquivoJSON(name);
    return of(name);
  }
}
