package JTpayment.MartInTown.domain.stock.service;

import JTpayment.MartInTown.domain.stock.presentation.dto.request.UpdateStockRequest;

public interface UpdateStockService {

    void execute(Long storeId, Long stockId, UpdateStockRequest request);
}
