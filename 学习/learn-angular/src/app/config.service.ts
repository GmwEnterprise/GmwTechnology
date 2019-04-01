import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Config } from './api/config';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient) { }

  configUrl = 'http://192.168.104.41:8080/assets/config.json';

  getConfig(): Observable<Config> {
    return this.http.get<Config>(this.configUrl)
      .pipe(
        retry(3),
        catchError(this.handleError)
      );
  }

  getConfigResponse(): Observable<HttpResponse<Config>> {
    return this.http.get<Config>(this.configUrl, {
      observe: 'response'
    });
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.log('An error occurred: ' + error.error.message);
    } else {
      console.error(`Backend returned code ${error.status}, body was: ${JSON.stringify(error.error)}`);
    }
    return throwError('Something bad happened; please try again later.');
  }
}
