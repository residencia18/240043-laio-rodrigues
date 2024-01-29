import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class WikiService {

  private apiUrl = 'https://pt.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=';

  constructor(private http: HttpClient) { }

  search(term: string): Observable<any> {
    const fullUrl = this.apiUrl + term + '&origin=*';
    return this.http.get(fullUrl);
  }
}