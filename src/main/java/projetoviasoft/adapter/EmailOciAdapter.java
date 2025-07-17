package projetoviasoft.adapter;

import projetoviasoft.dto.EmailOciDTO;
import projetoviasoft.dto.EmailRequestDTO;

public class EmailOciAdapter implements EmailAdapter {

    @Override
    public EmailOciDTO adaptar(EmailRequestDTO dto) {
        EmailOciDTO ociDTO = new EmailOciDTO();
        ociDTO.setRecipientEmail(dto.getDestinatarioEmail());
        ociDTO.setRecipientName(dto.getDestinatarioNome());
        ociDTO.setSenderEmail(dto.getRemetenteEmail());
        ociDTO.setSubject(dto.getAssunto());
        ociDTO.setBody(dto.getConteudo());
        return ociDTO;
    }
}
