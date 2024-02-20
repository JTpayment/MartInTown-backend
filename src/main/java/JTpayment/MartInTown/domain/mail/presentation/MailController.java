package JTpayment.MartInTown.domain.mail.presentation;

import JTpayment.MartInTown.domain.mail.presentation.dto.request.MailCheckRequest;
import JTpayment.MartInTown.domain.mail.presentation.dto.request.MailRequest;
import JTpayment.MartInTown.domain.mail.service.MailCheckService;
import JTpayment.MartInTown.domain.mail.service.MailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;
    private final MailCheckService mailCheckService;

    @PostMapping("/mail")
    public String mailSend(@RequestBody @Valid MailRequest req) {
        return mailService.execute(req.getEmail());
    }

    @PostMapping("/mail/check")
    public Boolean AuthCheck(@RequestBody @Valid MailCheckRequest req) {
        return mailCheckService.execute(req.getEmail(), req.getCode());
    }
}
