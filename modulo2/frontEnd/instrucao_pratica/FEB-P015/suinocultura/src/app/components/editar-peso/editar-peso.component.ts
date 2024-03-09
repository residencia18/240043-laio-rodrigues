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
    pesos: [],
  },
  {
    brinco: 'DEF456',
    brinco_pai: 'XYZ789',
    brinco_mae: 'ABC123',
    dt_nasc: '2019-04-10',
    dt_saida: ' ',
    status: 'Ativo',
    sexo: 'Macho',
    pesos: [],
  },
  {
    brinco: 'ABC456',
    brinco_pai: 'DEF456',
    brinco_mae: 'GHI789',
    dt_nasc: '2020-02-05',
    dt_saida: '2021-05-20',
    status: 'Vendido',
    sexo: 'Fêmea',
    pesos: [],
  },
  {
    brinco: 'DEF789',
    brinco_pai: 'XYZ789',
    brinco_mae: 'ABC123',
    dt_nasc: '2019-04-10',
    dt_saida: ' ',
    status: 'Ativo',
    sexo: 'Macho',
    pesos: [],
  },
  {
    brinco: 'ABC789',
    brinco_pai: 'DEF456',
    brinco_mae: 'GHI789',
    dt_nasc: '2020-02-05',
    dt_saida: '2021-05-20',
    status: 'Vendido',
    sexo: 'Fêmea',
    pesos: [],
  },
  {
    brinco: 'DEF231',
    brinco_pai: 'XYZ789',
    brinco_mae: 'ABC123',
    dt_nasc: '2019-04-10',
    dt_saida: ' ',
    status: 'Ativo',
    sexo: 'Macho',
    pesos: [],
  },
];

@Component({
  selector: 'app-editar-peso',
  templateUrl: './editar-peso.component.html',
  styleUrl: './editar-peso.component.css',
})
export class EditarPesoComponent {
  selectedItems: Suino[] = [];
  dropdownSettings: IDropdownSettings = {};
  suinos: Suino[] = SUINOS;
  formCadastro: FormGroup;
  campoBloqueado: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(true);
  campoBloqueado$: boolean = true;

  dataPesagemValidator = () => {
    // Verifica se o formulário está inicializado
    console.log('ok 1');
    if (!this.formCadastro) {
      console.log('falha');
      return null;
    }

    console.log('ok 2');
    const dataPesagem = this.formCadastro.get('dt_pesagem')?.value;
    const dataNascimento = this.selectedItems[0].dt_nasc;
    const dataSaida = this.selectedItems[0].dt_saida;

    console.log('ok 3');
    // Verifica se a data de pesagem foi preenchida
    if (!dataPesagem) {
      return null;
    }

    console.log('ok 4');
    const pesagem = new Date(dataPesagem);
    const nascimento = new Date(dataNascimento);
    const saida = new Date(dataSaida);

    console.log('ok 5');
    if (pesagem >= nascimento && pesagem <= saida) {
      return null;
    }
    console.log('ok 6');
    return { invalido: true };
  };

  constructor() {
    this.formCadastro = new FormGroup({
      brinco: new FormControl('', [Validators.required]),
      dt_pesagem: new FormControl(
        { value: '', disabled: this.campoBloqueado$ },
        [Validators.required, this.dataPesagemValidator]
      ),
      peso: new FormControl({ value: '', disabled: this.campoBloqueado$ }, [
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
    this.campoBloqueado.subscribe((valor) => {
      if (valor) {
        this.formCadastro.get('dt_pesagem')?.disable();
        this.formCadastro.get('peso')?.disable();
      } else {
        this.formCadastro.get('dt_pesagem')?.enable();
        this.formCadastro.get('peso')?.enable();
      }
    });
  }
  onItemSelect(item: any) {
    this.suinos.forEach((suino) => {
      if (suino.brinco === item.brinco) {
        this.formCadastro.get('brinco')?.setValue(item.brinco);
        this.selectedItems.push(suino);
        this.campoBloqueado.next(false);
      }
    });
  }
  onDeselect(item: any) {
    this.campoBloqueado.next(true);
    this.selectedItems.pop();
  }
  onSubmit() {
    console.log(this.formCadastro);
    if (this.formCadastro.valid) {
      this.suinos.forEach((suino) => {
        if (suino.brinco === this.formCadastro.get('brinco')?.value) {
          const obj = {
            peso: this.formCadastro.get('peso')?.value,
            dt_pesagem: this.formCadastro.get('dt_pesagem')?.value,
          };
          suino.pesos.push(obj);
          this.formCadastro.reset();
          alert('Pesagem cadastrada!');
        }
      });
      console.log(this.suinos);
    }
  }
}
