package JTpayment.MartInTown.domain.profile.service.impl;

import JTpayment.MartInTown.domain.profile.service.OwnStoreDeleteService;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.domain.store.exception.StoreNotfoundException;
import JTpayment.MartInTown.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnStoreDeleteServiceImpl implements OwnStoreDeleteService {

    private final StoreRepository storeRepository;

    @Override
    public void execute(Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(StoreNotfoundException::new);

        storeRepository.delete(store);
    }
}
