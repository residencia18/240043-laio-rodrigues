import { Component } from '@angular/core';
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { SuinosService } from '../../services/suinos.service';
import { Suino } from '../../model/suino';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { BehaviorSubject } from 'rxjs';

const SUINOS: Suino[] = [
  {
    brinco: 'ABC123',
    brinco_pai: 'DEF456',
    brinco_mae: 'GHI789',
    dt_nasc: '2020-02-05',
    dt_saida: '2021-05-20',
    status: 'Vendido',
    sexo: 'Fêmea',
  },
  {
    brinco: 'DEF456',
    brinco_pai: 'XYZ789',
    brinco_mae: 'ABC123',
    dt_nasc: '2019-04-10',
    dt_saida: ' ',
    status: 'Ativo',
    sexo: 'Macho',
  },
  {
    brinco: 'ABC456',
    brinco_pai: 'DEF456',
    brinco_mae: 'GHI789',
    dt_nasc: '2020-02-05',
    dt_saida: '2021-05-20',
    status: 'Vendido',
    sexo: 'Fêmea',
  },
  {
    brinco: 'DEF789',
    brinco_pai: 'XYZ789',
    brinco_mae: 'ABC123',
    dt_nasc: '2019-04-10',
    dt_saida: ' ',
    status: 'Ativo',
    sexo: 'Macho',
  },
  {
    brinco: 'ABC789',
    brinco_pai: 'DEF456',
    brinco_mae: 'GHI789',
    dt_nasc: '2020-02-05',
    dt_saida: '2021-05-20',
    status: 'Vendido',
    sexo: 'Fêmea',
  },
  {
    brinco: 'DEF231',
    brinco_pai: 'XYZ789',
    brinco_mae: 'ABC123',
    dt_nasc: '2019-04-10',
    dt_saida: ' ',
    status: 'Ativo',
    sexo: 'Macho',
  },
];


@Component({
  selector: 'app-cadastrar-peso',
  templateUrl: './cadastrar-peso.component.html',
  styleUrl: './cadastrar-peso.component.css',
})
export class CadastrarPesoComponent {
  selectedItems: Suino[] = [];
  dropdownSettings: IDropdownSettings = {};
  suinos: Suino[] = SUINOS;
  formCadastro: FormGroup;
  campoBloqueado: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(true);
  campoBloqueado$: boolean = true;


  dataPesagemValidator = () => {
    // Verifica se o formulário está inicializado
    if (!this.formCadastro || this.selectedItems.length === 0) {
      return null;
    }

    const dataPesagem = this.formCadastro.get('dt_pesagem')?.value;
    const dataNascimento = this.selectedItems[0].dt_nasc;
    const dataSaida = this.selectedItems[0].dt_saida;

    // Verifica se a data de pesagem foi preenchida
    if (!dataPesagem) {
      return null;
    }

    const nascimento = new Date(dataNascimento);
    const saida = new Date(dataSaida);
    const pesagem = new Date(dataPesagem);

    if (pesagem >= nascimento && pesagem <= saida) return null;

    return { invalido: true };
  };

  constructor() {
    this.formCadastro = new FormGroup({
      brinco: new FormControl('', [Validators.required]),
      dt_pesagem: new FormControl(
        { value: '', disabled: this.campoBloqueado$},
        [Validators.required, this.dataPesagemValidator]
      ),
      peso: new FormControl({ value: '', disabled: this.campoBloqueado$}, [
        Validators.required,
        Validators.pattern('[0-9]+$'),
      ]),
    });
  }
  ngOnInit() {
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'brinco',
      textField: 'brinco',
      limitSelection: 1,
      noFilteredDataAvailablePlaceholderText: 'Nenhum suíno encontrado!',
      itemsShowLimit: 4,
      allowSearchFilter: true,
    };
    this.campoBloqueado.subscribe(valor => {
      if(valor){
        this.formCadastro.get('dt_pesagem')?.disable();
        this.formCadastro.get('peso')?.disable();
      }else{
        this.formCadastro.get('dt_pesagem')?.enable();
        this.formCadastro.get('peso')?.enable();
      }
    });
  }
  onItemSelect(item: any) {
    this.suinos.forEach((suino) => {
      if (suino.brinco === item.brinco) {
        this.selectedItems.push(suino);
        this.campoBloqueado.next(false);
      }
    });
  }
  onDeselect(item: any) {
    this.campoBloqueado.next(true);
  }
  onSubmit() {
    console.log(this.formCadastro);
  }
}
