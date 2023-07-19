import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { logUser } from '../login/logUser';
import { BehaviorSubject, Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiUrl = 'http://localhost:8095/auth/user/login'; // Replace with your API endpoint URL

  constructor(private http: HttpClient) {}

  isLoggedIn = new BehaviorSubject(false);

  login(user:logUser):Observable<any>{
    return this.http.post<any>(this.apiUrl, user);
  }

  setToken(token:string){
    localStorage.setItem('token',token);
  }

  logout(){
    this.isLoggedIn.next(false);
  }

}


