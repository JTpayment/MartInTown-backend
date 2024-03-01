package JTpayment.MartInTown.domain.stock.service.Impl;

import JTpayment.MartInTown.domain.stock.entity.Stock;
import JTpayment.MartInTown.domain.stock.repository.StockRepository;
import JTpayment.MartInTown.domain.stock.service.DeleteStockService;
import JTpayment.MartInTown.global.annotation.ServiceWithTransactional;
import JTpayment.MartInTown.global.util.StockServiceUtil;
import JTpayment.MartInTown.global.util.StockUtil;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class DeleteStockServiceImpl implements DeleteStockService {

    private final StockRepository stockRepository;

    private final StockServiceUtil stockServiceUtil;

    private final StockUtil stockUtil;

    @Override
    public void execute(Long storeId, Long stockId) {

        stockServiceUtil.checkManagerAndStock(storeId, stockId);

        Stock stock = stockUtil.findById(stockId);

        stockRepository.delete(stock);
    }
}
