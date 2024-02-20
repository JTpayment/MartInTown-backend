package JTpayment.MartInTown.domain.auth.service;

public interface MemberLogoutService {
    void execute(String accessToken, String refreshToken);
}
