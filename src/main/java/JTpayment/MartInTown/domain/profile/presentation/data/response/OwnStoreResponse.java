package JTpayment.MartInTown.domain.profile.presentation.data.response;

import JTpayment.MartInTown.domain.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnStoreResponse {
    private Long storeId;

    private String storeName;

    private String address;

    public static OwnStoreResponse toResponse(Store store) {
        return OwnStoreResponse.builder()
                .storeId(store.getStoreId())
                .storeName(store.getStoreName())
                .address(store.getAddress())
                .build();
    }
}
