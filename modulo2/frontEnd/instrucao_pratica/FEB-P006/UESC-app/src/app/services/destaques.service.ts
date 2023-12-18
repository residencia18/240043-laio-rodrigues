import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})

export class DestaqueService {
  private apiUrl = 'https://api.unsplash.com';
  private accessKey = 'bOrsCP3BKCNcHpbSrJDQMgUM6GgmqvzwB2UHHv1l_yo';

  constructor(private http: HttpClient) {}

  getDestaques(): Observable<any> {
    const params = new HttpParams({
      fromObject: {
        query: 'education',
        per_page: '5',
      },
    });

    const headers = {
      'Authorization': `Client-ID ${this.accessKey}`,
    };

    return this.http.get<any>(`${this.apiUrl}/photos`, { params, headers })
      .pipe(
        catchError((error: HttpErrorResponse) => {
          console.error('Erro ao obter destaques do Unsplash:', error);
          console.error('Status do erro:', error.status);
          console.error('Mensagem do erro:', error.message);
          return throwError('Erro ao obter destaques do Unsplash. Verifique o console para mais detalhes.');
        })
      );
  }
  
}
