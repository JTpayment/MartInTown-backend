package JTpayment.MartInTown.domain.mail.service;

public interface MailCheckService {
    Boolean execute(String email, String code);
}
