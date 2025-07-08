package Service;

import adpter.EmailAdapterFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.EmailRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private EmailAdapterFactory factory;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void processarEmail(EmailRequestDTO dto) {
        Object emailDto = factory.getAdapter().adaptar(dto);
        try {
            String json = objectMapper.writeValueAsString(emailDto);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao serializar objeto");
        }
    }
}

