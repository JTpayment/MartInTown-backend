package JTpayment.MartInTown.domain.profile.repository;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.profile.entity.MemberFavoriteStore;
import JTpayment.MartInTown.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<MemberFavoriteStore, Long> {
    Optional<MemberFavoriteStore> findByMemberAndStore(Member member, Store store);

    Boolean existsByMemberAndStore(Member member, Store store);

    @Query("select s from Store s, MemberFavoriteStore mfs where s = mfs.store and mfs.member=:member")
    List<Store> findMyFavoriteStore(@Param("member") Member member);

    @Query("select s from Store s where s.manager=:member")
    List<Store> findOwnStore(Member member);
}
