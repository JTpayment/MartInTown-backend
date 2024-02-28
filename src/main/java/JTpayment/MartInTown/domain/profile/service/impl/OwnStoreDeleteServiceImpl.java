package JTpayment.MartInTown.domain.profile.service.impl;

import JTpayment.MartInTown.domain.profile.service.OwnStoreDeleteService;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.domain.store.exception.StoreNotfoundException;
import JTpayment.MartInTown.domain.store.repository.StoreRepository;
import JTpayment.MartInTown.global.util.StoreUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnStoreDeleteServiceImpl implements OwnStoreDeleteService {

    private final StoreRepository storeRepository;
    private final StoreUtil storeUtil;

    @Override
    public void execute(Long storeId) {
        Store store = storeUtil.findById(storeId);

        storeRepository.delete(store);
    }
}
