package projetoviasoft.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import projetoviasoft.dto.EmailRequestDTO;
import projetoviasoft.service.EmailService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmailController.class)
class EmailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmailService emailService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void enviarEmail_DeveRetornarNoContentEChamarService() throws Exception {
        EmailRequestDTO dto = new EmailRequestDTO();
        dto.setDestinatarioEmail("destino@exemplo.com");
        dto.setDestinatarioNome("Nome Destinatário");
        dto.setRemetenteEmail("remetente@exemplo.com");
        dto.setAssunto("Assunto");
        dto.setConteudo("Conteúdo");

        mockMvc.perform(post("/api/email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isNoContent());

        Mockito.verify(emailService).processarEmail(Mockito.any(EmailRequestDTO.class));
    }
}