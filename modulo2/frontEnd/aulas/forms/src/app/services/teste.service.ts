import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TesteService {

  constructor() { }

  show(name: string){
    console.log(name);
  }
}
