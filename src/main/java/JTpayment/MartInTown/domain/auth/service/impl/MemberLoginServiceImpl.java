package JTpayment.MartInTown.domain.auth.service.impl;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.auth.entity.RefreshToken;
import JTpayment.MartInTown.domain.auth.exception.MemberNotfoundException;
import JTpayment.MartInTown.domain.auth.presentation.data.request.MemberLoginRequest;
import JTpayment.MartInTown.domain.auth.presentation.data.response.MemberLoginResponse;
import JTpayment.MartInTown.domain.auth.repository.MemberRepository;
import JTpayment.MartInTown.domain.auth.repository.RefreshTokenRepository;
import JTpayment.MartInTown.domain.auth.service.MemberLoginService;
import JTpayment.MartInTown.global.annotation.ServiceWithTransactional;
import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;
import JTpayment.MartInTown.global.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@ServiceWithTransactional
@RequiredArgsConstructor
public class MemberLoginServiceImpl implements MemberLoginService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public MemberLoginResponse execute(MemberLoginRequest request) {
        Member member = memberRepository.findMemberByLoginId(request.getMemberId())
                .orElseThrow(MemberNotfoundException::new);

        if(!passwordEncoder.matches(request.getPassword(), member.getPassword())){
            throw new BasicException(ErrorCode.PASSWORD_INVALID);
        }

        String accessToken = tokenProvider.generateAccessToken(member.getLoginId());
        String refreshToken = tokenProvider.generateRefreshToken(member.getLoginId());
        RefreshToken tokenRedis = new RefreshToken(member.getLoginId(), refreshToken, tokenProvider.getTokenTimeProperties().getRefreshTime());

        refreshTokenRepository.save(tokenRedis);

        return MemberLoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessExpiredAt(tokenProvider.accessExpiredTime())
                .refreshExpiredAt(tokenProvider.refreshExpiredTime())
                .build();
    }

}
