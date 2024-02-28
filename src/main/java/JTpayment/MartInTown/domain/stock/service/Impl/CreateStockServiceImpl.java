package JTpayment.MartInTown.domain.stock.service.Impl;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.stock.entity.Stock;
import JTpayment.MartInTown.domain.stock.presentation.dto.request.CreateStockRequest;
import JTpayment.MartInTown.domain.stock.repository.StockRepository;
import JTpayment.MartInTown.domain.stock.service.CreateStockService;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.domain.store.exception.ManagerMismatchException;
import JTpayment.MartInTown.global.annotation.ServiceWithTransactional;
import JTpayment.MartInTown.global.util.MemberUtil;
import JTpayment.MartInTown.global.util.StoreUtil;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class CreateStockServiceImpl implements CreateStockService {

    private final StockRepository stockRepository;

    private final StoreUtil storeUtil;

    private final MemberUtil memberUtil;

    @Override
    public void execute(Long storeId, CreateStockRequest createStockRequest) {

        Store store = storeUtil.findById(storeId);

        Member member = memberUtil.currentMember();

        if (!store.getManager().equals(member)) {
            throw new ManagerMismatchException();
        }

        Stock stock = Stock.builder()
                .stockName(createStockRequest.getStockName())
                .price(createStockRequest.getPrice())
                .stock(createStockRequest.getStock())
                .image(createStockRequest.getImage())
                .store(store)
                .build();

        stockRepository.save(stock);
    }
}
