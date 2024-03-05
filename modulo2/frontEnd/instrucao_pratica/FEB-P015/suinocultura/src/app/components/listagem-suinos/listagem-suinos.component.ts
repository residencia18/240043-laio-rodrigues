import { Component, PipeTransform } from '@angular/core';
import { Suino } from '../../suino';

import { AsyncPipe, DecimalPipe } from '@angular/common';
import { FormControl, ReactiveFormsModule } from '@angular/forms';

import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { NgbHighlight } from '@ng-bootstrap/ng-bootstrap';

const COUNTRIES: Suino[] = [
  {
    brinco: 'ABC123',
    brinco_pai: 'DEF456',
    brinco_mae: 'GHI789',
    dt_nasc: '05-02-2020',
    dt_saida: '20-05-2021',
    status: 'Vendido',
    sexo: 'Fêmea',
  },
  {
    brinco: 'DEF456',
    brinco_pai: 'XYZ789',
    brinco_mae: 'ABC123',
    dt_nasc: '10-04-2019',
    dt_saida: ' ',
    status: 'Ativo',
    sexo: 'Macho',
  },
  {
    brinco: 'ABC456',
    brinco_pai: 'DEF456',
    brinco_mae: 'GHI789',
    dt_nasc: '05-02-2020',
    dt_saida: '20-05-2021',
    status: 'Vendido',
    sexo: 'Fêmea',
  },
  {
    brinco: 'DEF789',
    brinco_pai: 'XYZ789',
    brinco_mae: 'ABC123',
    dt_nasc: '10-04-2019',
    dt_saida: ' ',
    status: 'Ativo',
    sexo: 'Macho',
  },
  {
    brinco: 'ABC789',
    brinco_pai: 'DEF456',
    brinco_mae: 'GHI789',
    dt_nasc: '05-02-2020',
    dt_saida: '20-05-2021',
    status: 'Vendido',
    sexo: 'Fêmea',
  },
  {
    brinco: 'DEF231',
    brinco_pai: 'XYZ789',
    brinco_mae: 'ABC123',
    dt_nasc: '10-04-2019',
    dt_saida: ' ',
    status: 'Ativo',
    sexo: 'Macho',
  },
];

function search(text: string, pipe: PipeTransform): Suino[] {
  return COUNTRIES.filter((suino) => {
    const term = text.toLowerCase();
    return (
      suino.brinco.toLowerCase().includes(term) ||
      pipe.transform(suino.brinco_pai).includes(term) ||
      pipe.transform(suino.brinco_mae).includes(term)
    );
  });
}


@Component({
  selector: 'app-listagem-suinos',
  templateUrl: './listagem-suinos.component.html',
  styleUrls: ['./listagem-suinos.component.css'],
  providers: [DecimalPipe],
})
export class ListagemSuinosComponent {
  countries$: Observable<Suino[]>;
  filter = new FormControl('', { nonNullable: true });

  constructor(pipe: DecimalPipe) {
    this.countries$ = this.filter.valueChanges.pipe(
      startWith(''),
      map((text) => search(text, pipe))
    );
  }
}
