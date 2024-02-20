package JTpayment.MartInTown.domain.auth.service.impl;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.auth.entity.enums.Role;
import JTpayment.MartInTown.domain.auth.presentation.data.request.MemberSignupRequest;
import JTpayment.MartInTown.domain.auth.repository.MemberRepository;
import JTpayment.MartInTown.domain.auth.service.MemberSignupService;
import JTpayment.MartInTown.global.annotation.ServiceWithTransactional;
import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@ServiceWithTransactional
@RequiredArgsConstructor
public class MemberSignupServiceImpl implements MemberSignupService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void execute(MemberSignupRequest signUpRequest) {
        if(memberRepository.existsByLoginId(signUpRequest.getId()))
            throw new BasicException(ErrorCode.DUPLICATED_ID);

        if(memberRepository.existsByEmail(signUpRequest.getEmail()))
            throw new BasicException(ErrorCode.DUPLICATED_EMAIL);

        Member member = Member.builder()
                .loginId(signUpRequest.getId())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .email(signUpRequest.getEmail())
                .role(Role.USER)
                .build();

        memberRepository.save(member);
    }
}
