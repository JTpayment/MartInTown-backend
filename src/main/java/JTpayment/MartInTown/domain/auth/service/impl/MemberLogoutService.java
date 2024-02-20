package JTpayment.MartInTown.domain.auth.service.impl;

import JTpayment.MartInTown.domain.auth.entity.RefreshToken;
import JTpayment.MartInTown.domain.auth.repository.RefreshTokenRepository;
import JTpayment.MartInTown.global.annotation.ServiceWithTransactional;
import JTpayment.MartInTown.global.security.exception.TokenInvalidException;
import JTpayment.MartInTown.global.security.jwt.TokenProvider;
import JTpayment.MartInTown.global.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@ServiceWithTransactional
@RequiredArgsConstructor
@Slf4j
public class MemberLogoutService implements JTpayment.MartInTown.domain.auth.service.MemberLogoutService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final TokenProvider tokenProvider;
    private final RedisUtil redisUtil;

    @Override
    public void execute(String accessToken, String refreshToken) {

        String access = tokenProvider.parseToken(accessToken);

        String refresh = tokenProvider.parseToken(refreshToken);

        RefreshToken memberRefreshToken = refreshTokenRepository.findByRefreshToken(refresh);

        if (memberRefreshToken == null) {
            throw new TokenInvalidException();
        }

        refreshTokenRepository.delete(memberRefreshToken);

        Long expiration = tokenProvider.getExpiration(access);

        redisUtil.setBlackList(access, "logout", expiration);
    }
}
