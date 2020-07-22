import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DOCUMENT} from '@angular/common';
import {environment} from 'src/environments/environment.local';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  public apiBase: string = environment.api;

  constructor(public httpClient: HttpClient,
              @Inject(DOCUMENT) private document: Document) {
  }

  public post(path: string, payload?: any, options?: any): Observable<any> {
    if (options == null) {
      options = this.getHttpOptions();
    }
    return this.httpClient.post<any>(this.apiBase + path, payload, options);
  }

  public delete(path: string): Observable<any> {
    return this.httpClient.delete<any>(this.apiBase + path, this.getHttpOptions());

  }

  public get(path: string, options?: any): Observable<any> {
    if (options == null) {
      options = this.getHttpOptions();
    }
    return this.httpClient.get<any>(this.apiBase + path, options);
  }

  public getHttpOptions(): any {
    return {headers: this.getHttpHeaders()};
  }

  public getHttpHeaders(): any {
    const h = new Headers();
    h.append('Accept', 'application/json');
    h.append('Content-Type', 'application/json');
    return h;
  }

}

export class Student {
  id: number;
  firstName: string;
  lastName: string;
  number: number;
}
