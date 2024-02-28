package JTpayment.MartInTown.domain.profile.service.impl;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.profile.presentation.data.response.MyFavoriteStoreListResponse;
import JTpayment.MartInTown.domain.profile.presentation.data.response.MyFavoritesStoreResponse;
import JTpayment.MartInTown.domain.profile.repository.ProfileRepository;
import JTpayment.MartInTown.domain.profile.service.MyFavoritesService;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyFavoritesServiceImpl implements MyFavoritesService {

    private final ProfileRepository profileRepository;
    private final MemberUtil memberUtil;

    @Override
    public MyFavoriteStoreListResponse execute() {
        Member member = memberUtil.currentMember();

        List<Store> stores = profileRepository.findMyFavoriteStore(member);

        return MyFavoriteStoreListResponse.builder()
                .myFavoriteStoreList(
                        stores.stream()
                            .map(MyFavoritesStoreResponse::toResponse)
                            .collect(Collectors.toList())
                )
                .build();
    }
}
