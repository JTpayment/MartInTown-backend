package JTpayment.MartInTown.domain.profile.service.impl;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.profile.presentation.data.response.MyFavoriteStoreListResponse;
import JTpayment.MartInTown.domain.profile.presentation.data.response.MyFavoritesStoreResponse;
import JTpayment.MartInTown.domain.profile.presentation.data.response.OwnStoreListResponse;
import JTpayment.MartInTown.domain.profile.presentation.data.response.OwnStoreResponse;
import JTpayment.MartInTown.domain.profile.repository.ProfileRepository;
import JTpayment.MartInTown.domain.profile.service.OwnStoreService;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnStoreServiceImpl implements OwnStoreService {

    private final ProfileRepository profileRepository;
    private final MemberUtil memberUtil;

    public OwnStoreListResponse execute() {
        Member member = memberUtil.currentMember();
        List<Store> stores = profileRepository.findOwnStore(member);

        return OwnStoreListResponse.builder()
                .ownStoreList(
                        stores.stream()
                                .map(OwnStoreResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
