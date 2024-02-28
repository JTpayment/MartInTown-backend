package JTpayment.MartInTown.domain.profile.service.impl;

import JTpayment.MartInTown.domain.profile.presentation.data.request.OwnStoreEditRequest;
import JTpayment.MartInTown.domain.profile.service.OwnStoreEditService;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.domain.store.exception.StoreNotfoundException;
import JTpayment.MartInTown.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnStoreEditServiceImpl implements OwnStoreEditService {

    private final StoreRepository storeRepository;

    @Override
    public void execute(Long storeId, OwnStoreEditRequest request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(StoreNotfoundException::new);

        store.setStoreName(request.getStoreName());
        store.setAddress(request.getAddress());

        storeRepository.save(store);
    }
}
