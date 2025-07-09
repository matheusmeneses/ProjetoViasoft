package projetoviasoft.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import projetoviasoft.adapter.EmailAdapterFactory;
import projetoviasoft.dto.EmailAwsDTO;
import projetoviasoft.dto.EmailOciDTO;
import projetoviasoft.dto.EmailRequestDTO;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailAdapterFactory factory;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);


    public void processarEmail(EmailRequestDTO dto) {
        Object emailDto = factory.getAdapter().adaptar(dto);
        try {
            String json = objectMapper.writeValueAsString(emailDto);
            logger.info(json);
            enviarEmailAdaptado(emailDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao serializar objeto");
        }
    }

    protected void enviarEmailAdaptado(Object emailDto) {
        logger.info("Simulando envio de e-mail: {}", emailDto.getClass().getSimpleName());
        if (emailDto instanceof EmailAwsDTO) {
            logger.info("Simulação: Enviando via AWS");
        } else if (emailDto instanceof EmailOciDTO) {
            logger.info("Simulação: Enviando via OCI");
        }
    }
}

