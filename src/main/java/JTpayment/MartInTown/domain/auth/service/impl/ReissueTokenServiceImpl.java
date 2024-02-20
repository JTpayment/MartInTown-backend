package JTpayment.MartInTown.domain.auth.service.impl;

import JTpayment.MartInTown.domain.auth.entity.RefreshToken;
import JTpayment.MartInTown.domain.auth.presentation.data.response.NewTokenResponse;
import JTpayment.MartInTown.domain.auth.repository.RefreshTokenRepository;
import JTpayment.MartInTown.domain.auth.service.ReissueTokenService;
import JTpayment.MartInTown.global.annotation.ServiceWithTransactional;
import JTpayment.MartInTown.global.security.exception.TokenInvalidException;
import JTpayment.MartInTown.global.security.jwt.TokenProvider;
import JTpayment.MartInTown.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@ServiceWithTransactional
@RequiredArgsConstructor
public class ReissueTokenServiceImpl implements ReissueTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final TokenProvider tokenProvider;
    private JwtProperties jwtProperties;

    @Override
    public NewTokenResponse execute(String refreshToken) {

        String refresh = tokenProvider.parseToken(refreshToken);

        validateRefreshToken(refresh);

        String loginId = tokenProvider.exactLoginIdFromRefreshToken(refresh);

        String newAccessToken = tokenProvider.generateAccessToken(loginId);

        String newRefreshToken = tokenProvider.generateRefreshToken(loginId);

        ZonedDateTime accessExp = tokenProvider.accessExpiredTime();

        ZonedDateTime refreshExp = tokenProvider.refreshExpiredTime();

        RefreshToken newToken = new RefreshToken(loginId, newRefreshToken, tokenProvider.getTokenTimeProperties().getRefreshTime());

        refreshTokenRepository.save(newToken);

        return NewTokenResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .accessExp(accessExp)
                .refreshExp(refreshExp)
                .build();
    }

    private void validateRefreshToken(String refreshToken) {
        RefreshToken token = refreshTokenRepository.findByRefreshToken(refreshToken);

        if (token == null) {
            throw new TokenInvalidException();
        }
    }
}
