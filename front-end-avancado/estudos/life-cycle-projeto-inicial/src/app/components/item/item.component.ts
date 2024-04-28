import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { faPen, faTrash } from '@fortawesome/free-solid-svg-icons';
import { Item } from 'src/app/interfaces/iItem';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css'],
})
export class ItemComponent implements OnInit, OnChanges {
  @Input() item!: Item;
  @Output() emitindoEdicao = new EventEmitter();
  @Output() emitindoRemocao = new EventEmitter();

  faPen = faPen;
  faTrash = faTrash;

  constructor() {}

  ngOnInit(): void {}

  ngOnChanges(changes: SimpleChanges): void {}

  editarItem() {
    this.emitindoEdicao.emit(this.item);
  }

  itemMarcado(){
    this.item.comprado = !this.item.comprado
  }

  deletarItem() {
    this.emitindoRemocao.emit(this.item.id);
  }

}
