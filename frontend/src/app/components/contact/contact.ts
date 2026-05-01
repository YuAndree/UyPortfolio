import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {MessageForm} from '../models/messageForm.model';
import {MessageService} from "../../services/message-service";

@Component({
  selector: 'app-contact',
  imports: [
      FormsModule
  ],
  standalone: true,
  templateUrl: './contact.html',
  styleUrl: './contact.css',
})

export class Contact {

    constructor(private messageService: MessageService) {
    }

    form: MessageForm = {
      name: '',
      email: '',
      message: ''
    };

    public sendMessage() {
        this.messageService.sendMessage(this.form)
          .subscribe({
              next: (res) => { console.log("Message sent!", res);
              },
              error: (err) => {
                console.log('Message not sent', err);
              }
          });
    }
}
