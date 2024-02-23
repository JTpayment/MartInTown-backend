package JTpayment.MartInTown.domain.store.service.impl;

import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.domain.store.presentation.dto.response.StoreListResponse;
import JTpayment.MartInTown.domain.store.presentation.dto.response.StoreResponse;
import JTpayment.MartInTown.domain.store.repository.StoreRepository;
import JTpayment.MartInTown.domain.store.service.StoreListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreListServiceImpl implements StoreListService {

    private final StoreRepository storeRepository;

    @Override
    public StoreListResponse execute() {

        List<Store> storeList = storeRepository.findAll();

        return StoreListResponse.builder()
                .storeList(
                        storeList.stream()
                                .map(StoreResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
