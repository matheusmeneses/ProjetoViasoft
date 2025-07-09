package projetoviasoft.service;

import lombok.RequiredArgsConstructor;
import projetoviasoft.adapter.EmailAdapterFactory;
import projetoviasoft.dto.EmailRequestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao serializar objeto");
        }
    }
}

