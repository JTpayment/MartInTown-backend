package JTpayment.MartInTown.domain.stock.service;

import JTpayment.MartInTown.domain.stock.presentation.dto.response.StockListResponse;

public interface StockListService {

    StockListResponse execute(Long storeId);
}
