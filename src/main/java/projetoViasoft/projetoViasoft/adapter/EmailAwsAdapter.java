package projetoViasoft.projetoViasoft.adapter;

import projetoViasoft.projetoViasoft.dto.EmailAwsDTO;
import projetoViasoft.projetoViasoft.dto.EmailRequestDTO;

public class EmailAwsAdapter implements EmailAdapter {

    @Override
    public EmailAwsDTO adaptar(EmailRequestDTO dto) {
        if (dto.getDestinatarioEmail().length() > 45) {
            throw new IllegalArgumentException("E-mail do destinatário excede 45 caracteres");
        }
        if (dto.getDestinatarioNome().length() > 60) {
            throw new IllegalArgumentException("Nome do destinatário excede 60 caracteres");
        }
        if (dto.getRemetenteEmail().length() > 45) {
            throw new IllegalArgumentException("E-mail do remetente excede 45 caracteres");
        }
        if (dto.getAssunto().length() > 120) {
            throw new IllegalArgumentException("Assunto excede 120 caracteres");
        }
        if (dto.getConteudo().length() > 256) {
            throw new IllegalArgumentException("Conteúdo excede 256 caracteres");
        }

        EmailAwsDTO awsDTO = new EmailAwsDTO();
        awsDTO.setRecipient(dto.getDestinatarioEmail());
        awsDTO.setRecipientName(dto.getDestinatarioNome());
        awsDTO.setSender(dto.getRemetenteEmail());
        awsDTO.setSubject(dto.getAssunto());
        awsDTO.setContent(dto.getConteudo());
        return awsDTO;
    }
}
