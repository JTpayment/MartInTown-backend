package JTpayment.MartInTown.global.security.auth;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.auth.exception.MemberNotfoundException;
import JTpayment.MartInTown.domain.auth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findMemberByLoginId(username)
                .orElseThrow(MemberNotfoundException::new);

        return new AuthDetails(member);
    }
}