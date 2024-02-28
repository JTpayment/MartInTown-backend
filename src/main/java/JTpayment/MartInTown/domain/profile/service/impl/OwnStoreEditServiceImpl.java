package JTpayment.MartInTown.domain.profile.service.impl;

import JTpayment.MartInTown.domain.profile.presentation.data.request.OwnStoreEditRequest;
import JTpayment.MartInTown.domain.profile.service.OwnStoreEditService;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.domain.store.exception.StoreNotfoundException;
import JTpayment.MartInTown.domain.store.repository.StoreRepository;
import JTpayment.MartInTown.global.util.StoreUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnStoreEditServiceImpl implements OwnStoreEditService {

    private final StoreRepository storeRepository;
    private final StoreUtil storeUtil;

    @Override
    public void execute(Long storeId, OwnStoreEditRequest request) {
        Store store = storeUtil.findById(storeId);

        store.setStoreName(request.getStoreName());
        store.setAddress(request.getAddress());

        storeRepository.save(store);
    }
}
