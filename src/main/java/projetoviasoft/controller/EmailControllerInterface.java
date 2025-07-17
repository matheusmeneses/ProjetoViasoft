package projetoviasoft.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import projetoviasoft.dto.EmailRequestDTO;

public interface EmailControllerInterface {

    @Operation(summary = "Envia um e-mail adaptado para AWS ou OCI",
            description = "Recebe os dados do e-mail, adapta conforme configuração e simula o envio.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "E-mail processado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação ou campos inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    ResponseEntity<Void>  enviarEmail(@Valid @RequestBody EmailRequestDTO dto);
}
