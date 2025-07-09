package ProjetoViasoft.ProjetoViasoft.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailRequestDTO {
    @NotBlank
    @Email
    private String destinatarioEmail;
    @NotBlank
    private String destinatarioNome;
    @NotBlank
    @Email
    private String remetenteEmail;
    @NotBlank
    private String assunto;
    @NotBlank
    private String conteudo;
}
