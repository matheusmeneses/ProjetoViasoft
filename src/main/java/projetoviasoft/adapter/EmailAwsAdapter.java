package projetoviasoft.adapter;

import projetoviasoft.dto.EmailAwsDTO;
import projetoviasoft.dto.EmailRequestDTO;

public class EmailAwsAdapter implements EmailAdapter {

    @Override
    public EmailAwsDTO adaptar(EmailRequestDTO dto) {
        EmailAwsDTO awsDTO = new EmailAwsDTO();
        awsDTO.setRecipient(dto.getDestinatarioEmail());
        awsDTO.setRecipientName(dto.getDestinatarioNome());
        awsDTO.setSender(dto.getRemetenteEmail());
        awsDTO.setSubject(dto.getAssunto());
        awsDTO.setContent(dto.getConteudo());
        return awsDTO;
    }
}
