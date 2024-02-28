package JTpayment.MartInTown.domain.profile.service;

import JTpayment.MartInTown.domain.profile.presentation.data.response.OwnStoreDetailResponse;

public interface OwnStoreDetailService {
    OwnStoreDetailResponse execute(Long storeId);
}
