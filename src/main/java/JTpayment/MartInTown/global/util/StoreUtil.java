package JTpayment.MartInTown.global.util;

import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.domain.store.exception.StoreNotfoundException;
import JTpayment.MartInTown.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreUtil {

    private final StoreRepository storeRepository;

    public Store findById(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(StoreNotfoundException::new);
    }
}
