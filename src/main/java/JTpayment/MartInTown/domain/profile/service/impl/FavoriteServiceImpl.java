package JTpayment.MartInTown.domain.profile.service.impl;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.profile.entity.MemberFavoriteStore;
import JTpayment.MartInTown.domain.profile.repository.ProfileRepository;
import JTpayment.MartInTown.domain.profile.service.FavoriteService;
import JTpayment.MartInTown.domain.profile.exception.DuplicatedFavoriteStoreException;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.global.util.MemberUtil;
import JTpayment.MartInTown.global.util.StoreUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final ProfileRepository profileRepository;
    private final MemberUtil memberUtil;
    private final StoreUtil storeUtil;

    @Override
    public void execute(Long storeId) {
        Member member = memberUtil.currentMember();
        Store store = storeUtil.findById(storeId);

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
