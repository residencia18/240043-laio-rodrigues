import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-second-categoria',
  templateUrl: './second-categoria.component.html',
  styleUrl: './second-categoria.component.css'
})
export class SecondCategoriaComponent {
  @Input() selectedNames: string[] = [];
  @Input() selectedType: string = "";
  
  a = console.log(this.selectedType)
}
