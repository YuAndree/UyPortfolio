import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MessageForm } from '../components/models/messageForm.model';

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  private apiUrl = 'http://localhost:8080/api/contact';

  constructor(private http: HttpClient) {}

  sendMessage(form: MessageForm){
    return this.http.post(this.apiUrl, form, { responseType: 'text' });
  }
}
