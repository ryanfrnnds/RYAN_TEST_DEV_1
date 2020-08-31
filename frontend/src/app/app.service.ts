import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import {environment} from './../environments/environment';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AppService {
  // Normalmente eu criaria um companyService. Dependendo de como ele seria utilizado poderia
  // cria-lo como providedIn: 'root' fazendo parte do CORE ou apenas utilizado em seu próprio contexto
  // como sendo um servico de uma página especifica.
  private get baseUrlCompany(): string {
    return environment.apiUrl + 'company/';
  }

  constructor(private http: HttpClient) { }

  public getCompanies(): Observable<any> {
    const recurso = 'standartDeviations';
    return this.http.get(this.baseUrlCompany + recurso);
  }
}
