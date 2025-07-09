package projetoviasoft.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailRequestDTO {
    @NotBlank
    @Email
    @Schema(description = "E-mail do destinatário", example = "destino@exemplo.com")
    private String destinatarioEmail;
    @NotBlank
    @Schema(description = "Nome do destinatário", example = "Nome Destinatário")
    private String destinatarioNome;
    @NotBlank
    @Email
    @Schema(description = "E-mail do remetente", example = "remetente@exemplo.com")
    private String remetenteEmail;
    @NotBlank
    @Schema(description = "Assunto do e-mail", example = "Assunto do email")
    private String assunto;
    @NotBlank
    @Schema(description = "Conteúdo do e-mail", example = "Conteúdo do email")
    private String conteudo;
}
