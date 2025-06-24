// src/app/services/interior-design.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InteriorDesignService {
  private readonly baseUrl = 'http://localhost:8080/services/service/name';

  constructor(private readonly http: HttpClient) {}

  getServiceByName(title: string): Observable<any> {
    return this.http.get(`${this.baseUrl}?title=${title}`);
  }
  getAllServices(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getServiceById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
}
