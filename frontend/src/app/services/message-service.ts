import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MessageForm } from '../components/models/messageForm.model';

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  private apiUrl = 'https://uyportfoliov2.onrender.com/api/contact';

  constructor(private http: HttpClient) {}

  sendMessage(form: MessageForm) {
    return this.http.post(this.apiUrl, form, { responseType: 'text' });
  }
}
