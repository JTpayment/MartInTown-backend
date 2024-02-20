package JTpayment.MartInTown.domain.auth.repository;

import JTpayment.MartInTown.domain.auth.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    boolean existsByLoginId(String loginId);
    boolean existsByEmail(String email);

    Optional<Member> findMemberByLoginId(String loginId);
}
