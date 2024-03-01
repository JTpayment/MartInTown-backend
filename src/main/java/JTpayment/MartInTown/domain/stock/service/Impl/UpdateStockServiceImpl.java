package JTpayment.MartInTown.domain.stock.service.Impl;

import JTpayment.MartInTown.domain.stock.entity.Stock;
import JTpayment.MartInTown.domain.stock.presentation.dto.request.UpdateStockRequest;
import JTpayment.MartInTown.domain.stock.repository.StockRepository;
import JTpayment.MartInTown.domain.stock.service.UpdateStockService;
import JTpayment.MartInTown.global.annotation.ServiceWithTransactional;
import JTpayment.MartInTown.global.util.StockServiceUtil;
import JTpayment.MartInTown.global.util.StockUtil;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class UpdateStockServiceImpl implements UpdateStockService {

    private final StockRepository stockRepository;

    private final StockServiceUtil stockServiceUtil;

    private final StockUtil stockUtil;


    @Override
    public void execute(Long storeId, Long stockId, UpdateStockRequest request) {

        stockServiceUtil.checkManagerAndStock(storeId, stockId);

        Stock stock = stockUtil.findById(stockId);

        stock.update(request);

        stockRepository.save(stock);
    }
}
