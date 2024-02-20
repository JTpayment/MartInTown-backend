package JTpayment.MartInTown.domain.mail.presentation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class MailRequest {
    @Email
    @NotEmpty(message = "이메일을 입력해 주세요")
    private String email;
}