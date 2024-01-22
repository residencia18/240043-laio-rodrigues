import { Component, Input } from '@angular/core';
import { ServiceService } from '../../service.service';

@Component({
  selector: 'app-resultado',
  templateUrl: './resultado.component.html',
  styleUrl: './resultado.component.css'
})
export class ResultadoComponent {
  @Input() busca = "";

  constructor(private apiWiki: ServiceService){
    
  }
}