import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class NoticiasService {
  private apiUrl = 'https://newsapi.org/v2/everything/';
  private apiKey = '900fd3c9be1e4f61acec6989f74e6c65';

  constructor(private http: HttpClient) {}

  getNoticiasCursosSuperiores(): Observable<any> {
    const params = new HttpParams({
      fromObject: {
        q: 'higher education',
        apiKey: this.apiKey,
      },
    });

    return this.http.get<any>(this.apiUrl, { params })
      .pipe(
        catchError((error: HttpErrorResponse) => {
          console.error('Erro ao obter notícias de cursos superiores:', error);
          console.error('Status do erro:', error.status);
          console.error('Mensagem do erro:', error.message);
          return throwError('Erro ao obter notícias de cursos superiores. Verifique o console para mais detalhes.');
        })
      );
  }
}
