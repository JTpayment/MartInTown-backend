package JTpayment.MartInTown.domain.stock.service;

import JTpayment.MartInTown.domain.stock.presentation.dto.request.CreateStockRequest;

public interface CreateStockService {

    void execute(Long storeId, CreateStockRequest createStockRequest);
}
