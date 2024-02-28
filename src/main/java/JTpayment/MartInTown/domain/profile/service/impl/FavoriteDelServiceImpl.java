package JTpayment.MartInTown.domain.profile.service.impl;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.profile.entity.MemberFavoriteStore;
import JTpayment.MartInTown.domain.profile.exception.FavoriteStoreNotfoundException;
import JTpayment.MartInTown.domain.profile.repository.ProfileRepository;
import JTpayment.MartInTown.domain.profile.service.FavoriteDelService;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.global.util.MemberUtil;
import JTpayment.MartInTown.global.util.StoreUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteDelServiceImpl implements FavoriteDelService {
    private final ProfileRepository profileRepository;
    private final MemberUtil memberUtil;
    private final StoreUtil storeUtil;

    @Override
    public void execute(Long storeId) {
        Member member = memberUtil.currentMember();
        Store store = storeUtil.findById(storeId);

        MemberFavoriteStore favoriteStore = profileRepository.findByMemberAndStore(member, store)
                .orElseThrow(FavoriteStoreNotfoundException::new);

        profileRepository.delete(favoriteStore);
    }
}
