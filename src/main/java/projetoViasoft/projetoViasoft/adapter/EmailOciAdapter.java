package projetoViasoft.projetoViasoft.adapter;

import projetoViasoft.projetoViasoft.dto.EmailOciDTO;
import projetoViasoft.projetoViasoft.dto.EmailRequestDTO;

public class EmailOciAdapter implements EmailAdapter {

    @Override
    public EmailOciDTO adaptar(EmailRequestDTO dto) {

        if (dto.getDestinatarioEmail().length() > 40) {
            throw new IllegalArgumentException("E-mail do destinatário excede 40 caracteres");
        }
        if (dto.getDestinatarioNome().length() > 50) {
            throw new IllegalArgumentException("Nome do destinatário excede 50 caracteres");
        }
        if (dto.getRemetenteEmail().length() > 40) {
            throw new IllegalArgumentException("E-mail do remetente excede 40 caracteres");
        }
        if (dto.getAssunto().length() > 100) {
            throw new IllegalArgumentException("Assunto excede 100 caracteres");
        }
        if (dto.getConteudo().length() > 250) {
            throw new IllegalArgumentException("Conteúdo excede 250 caracteres");
        }

        EmailOciDTO ociDTO = new EmailOciDTO();
        ociDTO.setRecipientEmail(dto.getDestinatarioEmail());
        ociDTO.setRecipientName(dto.getDestinatarioNome());
        ociDTO.setSenderEmail(dto.getRemetenteEmail());
        ociDTO.setSubject(dto.getAssunto());
        ociDTO.setBody(dto.getConteudo());
        return ociDTO;
    }
}
