package com.uy.portfolio.service;


import com.resend.Resend;
import com.resend.services.emails.model.CreateEmailOptions;
import com.uy.portfolio.dto.MessageFormDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageFormService {

    @Value("${spring.resend.api-key}")
    private String resendApiKey;

    @Value("${spring.resend.username}")
    private String email;

    public void sendMessage (MessageFormDto messageRequest) throws Exception{
        Resend resend = new Resend(resendApiKey);

        CreateEmailOptions createEmailOptions = CreateEmailOptions.builder()
            .from("onboarding@resend.dev")
            .to(email)
            .subject("New message from: " + messageRequest.getName())
            .text(
                    "Name: " + messageRequest.getName() +
                    "\nEmail: " + messageRequest.getEmail() +
                    "\nMessage: " + messageRequest.getMessage())
            .build();

        resend.emails().send(createEmailOptions);
    }
}
