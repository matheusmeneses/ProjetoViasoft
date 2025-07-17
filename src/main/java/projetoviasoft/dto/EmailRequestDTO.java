package projetoviasoft.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmailRequestDTO {
    @NotBlank
    @Email
    @Size(min = 1, max = 45)
    @Schema(description = "E-mail do destinatário", example = "destino@exemplo.com")
    private String destinatarioEmail;
    @NotBlank
    @Size(min = 1, max = 60)
    @Schema(description = "Nome do destinatário", example = "Nome Destinatário")
    private String destinatarioNome;
    @NotBlank
    @Email
    @Size(min = 1, max = 45)
    @Schema(description = "E-mail do remetente", example = "remetente@exemplo.com")
    private String remetenteEmail;
    @NotBlank
    @Size(min = 1, max = 120)
    @Schema(description = "Assunto do e-mail", example = "Assunto do email")
    private String assunto;
    @NotBlank
    @Size(min = 1, max = 256)
    @Schema(description = "Conteúdo do e-mail", example = "Conteúdo do email")
    private String conteudo;
}
