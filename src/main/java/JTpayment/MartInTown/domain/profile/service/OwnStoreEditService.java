package JTpayment.MartInTown.domain.profile.service;

import JTpayment.MartInTown.domain.profile.presentation.data.request.OwnStoreEditRequest;

public interface OwnStoreEditService {
    void execute(Long storeId, OwnStoreEditRequest request);
}
