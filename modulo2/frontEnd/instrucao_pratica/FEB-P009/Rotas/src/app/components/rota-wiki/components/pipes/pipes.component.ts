import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'boldSearch'
})

export class BoldSearchPipe implements PipeTransform {
  transform(value: string, term: string): string {
    if (!value || !term) {
      return value;
    }

    const regex = new RegExp(term, 'gi');
    return value.replace(regex, match => `<strong>${match}</strong>`);
  }
}