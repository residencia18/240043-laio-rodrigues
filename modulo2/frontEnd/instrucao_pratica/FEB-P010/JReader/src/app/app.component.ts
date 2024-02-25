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


}
