    package com.uy.portfolio.controllers;

    import com.uy.portfolio.dto.MessageFormDto;
    import com.uy.portfolio.service.MessageFormService;
    import jakarta.validation.Valid;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/contact")
    @CrossOrigin(origins = "https://uy-portfolio.vercel.app")
    public class MessageFormController {
        private final MessageFormService messageFormService;

        public MessageFormController(MessageFormService messageFormService){
            this.messageFormService = messageFormService;
        }

        @PostMapping
        public ResponseEntity<String> createMessage(@RequestBody @Valid MessageFormDto message){
            try {
                messageFormService.sendMessage(message);
                return ResponseEntity.ok("Message sent successfully!");
            } catch(Exception e) {
                return ResponseEntity.status(500).body(e.getMessage());
            }
        }

    }
