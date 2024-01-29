import { Component, Input } from '@angular/core';
import { WikiService } from './components/services/wiki.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Wiki API';

  busca = "";
  resultados: any[] = [];

  constructor(private wikiService: WikiService) {}

  onPesquisa(busca: string){
    this.busca = busca;
    this.wikiService.search(busca).subscribe(data => {
      this.resultados = data.query.search;
    });
  }
}
