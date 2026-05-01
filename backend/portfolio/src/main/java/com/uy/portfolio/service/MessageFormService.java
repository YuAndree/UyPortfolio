package com.uy.portfolio.service;


import com.uy.portfolio.dto.MessageFormDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageFormService {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String email;

    public MessageFormService (JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendMessage (MessageFormDto messageRequest){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom(email);
        message.setSubject("New message from: " + messageRequest.getName());
        message.setText(
                "Name: " + messageRequest.getName() +
                "\nEmail: " + messageRequest.getEmail() +
                "\nMessage: " + messageRequest.getMessage()
        );
        javaMailSender.send(message);
    }
}
