package projetoViasoft.projetoViasoft.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailAdapterFactory {

    @Value("${mail.integracao}")
    private String integracao;

    public EmailAdapter getAdapter() {
        if ("AWS".equalsIgnoreCase(integracao)) {
            return new EmailAwsAdapter();
        } else if ("OCI".equalsIgnoreCase(integracao)) {
            return new EmailOciAdapter();
        }
        throw new IllegalArgumentException("Integração inválida");
    }
}
