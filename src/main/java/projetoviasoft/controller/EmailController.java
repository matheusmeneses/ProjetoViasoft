package projetoviasoft.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoviasoft.dto.EmailRequestDTO;
import projetoviasoft.service.EmailService;


@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController implements  EmailControllerInterface {

    private final EmailService emailService;

    public ResponseEntity<Void> enviarEmail(@Valid @RequestBody EmailRequestDTO dto) {
        emailService.processarEmail(dto);
        return ResponseEntity.noContent().build();
    }
}

