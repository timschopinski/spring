import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Directors } from "../model/directors";
import {DirectorDetails} from "../model/director-details";
import {DirectorForm} from "../model/director-form";

@Injectable({
  providedIn: 'root'
})
export class DirectorService {
  private readonly backendHost = 'http://localhost:8083';

  constructor(private http: HttpClient) { }

  getDirectors(): Observable<Directors> {
    return this.http.get<Directors>(this.backendHost + '/api/directors');
  }

  getDirector(directorId: string): Observable<DirectorDetails> {
    return this.http.get<DirectorDetails>(this.backendHost + '/api/directors/' + directorId);
  }
  createDirector(request: DirectorForm): Observable<any> {
    return this.http.post(this.backendHost + '/api/directors', request);
  }

  putDirector(directorId: string, request: DirectorForm): Observable<any> {
    return this.http.put(this.backendHost + '/api/directors/' + directorId, request);
  }

  deleteDirector(directorId: string): Observable<any> {
    return this.http.delete(this.backendHost + '/api/directors/' + directorId);
  }
}
