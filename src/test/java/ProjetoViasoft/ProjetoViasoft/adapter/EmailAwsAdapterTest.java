package ProjetoViasoft.ProjetoViasoft.adapter;

import ProjetoViasoft.ProjetoViasoft.dto.EmailAwsDTO;
import ProjetoViasoft.ProjetoViasoft.dto.EmailRequestDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailAwsAdapterTest {

    @Test
    void adaptar_DeveMapearCamposCorretamente() {
        EmailRequestDTO dto = new EmailRequestDTO();
        dto.setDestinatarioEmail("destino@exemplo.com");
        dto.setDestinatarioNome("Nome Destinatário");
        dto.setRemetenteEmail("remetente@exemplo.com");
        dto.setAssunto("Assunto");
        dto.setConteudo("Conteúdo");

        EmailAwsAdapter adapter = new EmailAwsAdapter();
        EmailAwsDTO awsDTO = adapter.adaptar(dto);

        assertEquals(dto.getDestinatarioEmail(), awsDTO.getRecipient());
        assertEquals(dto.getDestinatarioNome(), awsDTO.getRecipientName());
        assertEquals(dto.getRemetenteEmail(), awsDTO.getSender());
        assertEquals(dto.getAssunto(), awsDTO.getSubject());
        assertEquals(dto.getConteudo(), awsDTO.getContent());
    }

    @Test
    void adaptar_DeveLancarExcecao_QuandoCampoExcedeLimite() {
        EmailRequestDTO dto = new EmailRequestDTO();
        dto.setDestinatarioEmail("x".repeat(46)); // excede limite
        dto.setDestinatarioNome("Nome");
        dto.setRemetenteEmail("remetente@exemplo.com");
        dto.setAssunto("Assunto");
        dto.setConteudo("Conteúdo");

        EmailAwsAdapter adapter = new EmailAwsAdapter();

        assertThrows(IllegalArgumentException.class, () -> adapter.adaptar(dto));
    }
}
