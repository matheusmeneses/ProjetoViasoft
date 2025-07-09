package ProjetoViasoft.ProjetoViasoft.Service;

import ProjetoViasoft.ProjetoViasoft.adapter.EmailAdapterFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ProjetoViasoft.ProjetoViasoft.dto.EmailRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailAdapterFactory factory;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public EmailService(EmailAdapterFactory factory) {
        this.factory = factory;
    }

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

