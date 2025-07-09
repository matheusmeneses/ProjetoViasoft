package projetoViasoft.projetoViasoft.controller;

import projetoViasoft.projetoViasoft.service.EmailService;
import projetoViasoft.projetoViasoft.dto.EmailRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> enviarEmail(@Valid @RequestBody EmailRequestDTO dto) {
        emailService.processarEmail(dto);
        return ResponseEntity.noContent().build();
    }
}

