import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private apiUrl = 'http://example.com/api/reservation'; // Replace with your API endpoint URL

  constructor(private http: HttpClient) {}

  reserveTable(reservationData: any): Observable<any> {
    return this.http.post(this.apiUrl, reservationData);
  }
}