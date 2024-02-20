package JTpayment.MartInTown.global.util;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.auth.exception.MemberNotfoundException;
import JTpayment.MartInTown.domain.auth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberUtil {
    private final MemberRepository memberRepository;

    public Member currentMember() {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return memberRepository.findMemberByLoginId(id)
                .orElseThrow(MemberNotfoundException::new);
    }
}
