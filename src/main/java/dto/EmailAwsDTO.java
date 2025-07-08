package dto;

import jakarta.validation.constraints.Size;

public class EmailAwsDTO {
    @Size(max = 45) private String recipient;
    @Size(max = 60) private String recipientName;
    @Size(max = 45) private String sender;
    @Size(max = 120) private String subject;
    @Size(max = 256) private String content;
}
