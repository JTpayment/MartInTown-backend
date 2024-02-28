package JTpayment.MartInTown.domain.stock.service.Impl;

import JTpayment.MartInTown.domain.stock.entity.Stock;
import JTpayment.MartInTown.domain.stock.presentation.dto.response.StockListResponse;
import JTpayment.MartInTown.domain.stock.presentation.dto.response.StockResponse;
import JTpayment.MartInTown.domain.stock.repository.StockRepository;
import JTpayment.MartInTown.domain.stock.service.StockListService;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.global.util.StoreUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StockListServiceImpl implements StockListService {

    private final StockRepository stockRepository;

    private final StoreUtil storeUtil;

    @Override
    public StockListResponse execute(Long storeId) {

        Store store = storeUtil.findById(storeId);

        List<Stock> stockList = stockRepository.findByStore(store);

        return StockListResponse.builder()
                .stockList(
                        stockList.stream()
                                .map(StockResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
