package JTpayment.MartInTown.domain.auth.service;

import JTpayment.MartInTown.domain.auth.presentation.data.response.NewTokenResponse;

public interface ReissueTokenService {
    NewTokenResponse execute(String refreshToken);
}
