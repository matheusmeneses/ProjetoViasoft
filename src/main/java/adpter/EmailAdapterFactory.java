package adpter;

import lombok.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailAdapterFactory {
    @Value("${mail.integracao}")
    private String integracao;

    public EmailAdapter getAdapter() {
        if ("AWS".equalsIgnoreCase(integracao)) {
            return new EmailAwsAdapter();
        }
        throw new IllegalArgumentException("Integração inválida");
    }
}
