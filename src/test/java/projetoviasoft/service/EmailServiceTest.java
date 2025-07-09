package projetoviasoft.service;

import projetoviasoft.adapter.EmailAdapter;
import projetoviasoft.adapter.EmailAdapterFactory;
import projetoviasoft.dto.EmailRequestDTO;
import projetoviasoft.dto.EmailAwsDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EmailServiceTest {

    @Test
    void processarEmail_DeveSerializarEImprimirEEnviar() throws JsonProcessingException {
        EmailRequestDTO dto = new EmailRequestDTO();
        dto.setDestinatarioEmail("destino@exemplo.com");
        dto.setDestinatarioNome("Nome Destinatário");
        dto.setRemetenteEmail("remetente@exemplo.com");
        dto.setAssunto("Assunto");
        dto.setConteudo("Conteúdo");

        EmailAwsDTO awsDTO = new EmailAwsDTO();
        awsDTO.setRecipientName("Destinatario Nome");
        awsDTO.setRecipient("Destinatario Email");
        awsDTO.setSender("Destinatario");
        awsDTO.setSubject("Assunto");
        awsDTO.setContent("Conteudo");

        EmailAdapter adapterMock = mock(EmailAdapter.class);
        when(adapterMock.adaptar(dto)).thenReturn(awsDTO);

        EmailAdapterFactory factoryMock = mock(EmailAdapterFactory.class);
        when(factoryMock.getAdapter()).thenReturn(adapterMock);

        // Crie um spy do EmailService
        EmailService service = spy(new EmailService(factoryMock));

        service.processarEmail(dto);

        verify(factoryMock, times(1)).getAdapter();
        verify(adapterMock, times(1)).adaptar(dto);

        // Verifica se o método de envio foi chamado
        verify(service, times(1)).enviarEmailAdaptado(awsDTO);
    }
}
