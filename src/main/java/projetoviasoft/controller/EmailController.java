package projetoviasoft.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetoviasoft.dto.EmailRequestDTO;
import projetoviasoft.service.EmailService;


@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @Operation(summary = "Envia um e-mail adaptado para AWS ou OCI",
            description = "Recebe os dados do e-mail, adapta conforme configuração e simula o envio.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "E-mail processado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação ou campos inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public ResponseEntity<Void> enviarEmail(@Valid @RequestBody EmailRequestDTO dto) {
        emailService.processarEmail(dto);
        return ResponseEntity.noContent().build();
    }
}

