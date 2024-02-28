package JTpayment.MartInTown.domain.profile.service.impl;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.auth.repository.MemberRepository;
import JTpayment.MartInTown.domain.profile.entity.MemberFavoriteStore;
import JTpayment.MartInTown.domain.profile.repository.ProfileRepository;
import JTpayment.MartInTown.domain.profile.service.FavoriteService;
import JTpayment.MartInTown.domain.profile.exception.DuplicatedFavoriteStoreException;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.domain.store.exception.StoreNotfoundException;
import JTpayment.MartInTown.domain.store.repository.StoreRepository;
import JTpayment.MartInTown.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ProfileRepository profileRepository;
    private final MemberUtil memberUtil;

    @Override
    public void execute(Long storeId) {
        Member member = memberUtil.currentMember();
        Store store = storeRepository.findById(storeId)
                .orElseThrow(StoreNotfoundException::new);

        if (profileRepository.existsByMemberAndStore(member, store)) {
            throw new DuplicatedFavoriteStoreException();
        }

        MemberFavoriteStore memberFavoriteStore = MemberFavoriteStore.builder()
                .member(member)
                .store(store)
                .build();
        profileRepository.save(memberFavoriteStore);
    }
}
