import { Component } from '@angular/core';
import { WikiService } from './components/services/wiki.service';

@Component({
  selector: 'app-rota-wiki',
  templateUrl: './rota-wiki.component.html',
  styleUrl: './rota-wiki.component.css',
})
export class RotaWikiComponent {
  title = 'Wiki API';

  busca = '';
  resultados: any[] = [];

  constructor(private wikiService: WikiService) {}

  onPesquisa(busca: string) {
    this.busca = busca;
    this.wikiService.search(busca).subscribe((data) => {
      this.resultados = data.query.search;
    });
  }
}
