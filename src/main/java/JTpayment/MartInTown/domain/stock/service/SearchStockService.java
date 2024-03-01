package JTpayment.MartInTown.domain.stock.service;

import JTpayment.MartInTown.domain.stock.presentation.dto.response.StockListResponse;

public interface SearchStockService {

    StockListResponse execute(Long storeId, String key);
}
