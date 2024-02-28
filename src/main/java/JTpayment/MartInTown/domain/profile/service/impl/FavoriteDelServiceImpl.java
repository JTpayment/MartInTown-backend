package JTpayment.MartInTown.domain.profile.service.impl;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.auth.exception.MemberNotfoundException;
import JTpayment.MartInTown.domain.auth.repository.MemberRepository;
import JTpayment.MartInTown.domain.profile.entity.MemberFavoriteStore;
import JTpayment.MartInTown.domain.profile.exception.FavoriteStoreNotfoundException;
import JTpayment.MartInTown.domain.profile.repository.ProfileRepository;
import JTpayment.MartInTown.domain.profile.service.FavoriteDelService;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.domain.store.exception.StoreNotfoundException;
import JTpayment.MartInTown.domain.store.repository.StoreRepository;
import JTpayment.MartInTown.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteDelServiceImpl implements FavoriteDelService {


    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ProfileRepository profileRepository;
    private final MemberUtil memberUtil;

    @Override
    public void execute(Long storeId) {
        Member member = memberRepository.findByMemberId(memberUtil.currentMember().getMemberId())
                .orElseThrow(MemberNotfoundException::new);
        Store store = storeRepository.findById(storeId)
                .orElseThrow(StoreNotfoundException::new);

        MemberFavoriteStore favoriteStore = profileRepository.findByMemberAndStore(member, store)
                .orElseThrow(FavoriteStoreNotfoundException::new);

        profileRepository.delete(favoriteStore);
    }
}
