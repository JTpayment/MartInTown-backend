package JTpayment.MartInTown.domain.profile.service.impl;

import JTpayment.MartInTown.domain.profile.presentation.data.response.OwnStoreDetailResponse;
import JTpayment.MartInTown.domain.profile.service.OwnStoreDetailService;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.domain.store.exception.StoreNotfoundException;
import JTpayment.MartInTown.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnStoreDetailServiceImpl implements OwnStoreDetailService {
    private final StoreRepository storeRepository;
    @Override
    public OwnStoreDetailResponse execute(Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(StoreNotfoundException::new);

        return OwnStoreDetailResponse.builder()
                .storeId(store.getStoreId())
                .address(store.getAddress())
                .storeName(store.getStoreName())
                .image(store.getImage())
                .build();
    }
}
