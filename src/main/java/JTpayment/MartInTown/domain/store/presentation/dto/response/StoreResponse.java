package JTpayment.MartInTown.domain.store.presentation.dto.response;

import JTpayment.MartInTown.domain.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponse {

    private Long storeId;

    private String address;

    public static StoreResponse toResponse(Store store) {

        return StoreResponse.builder()
                .storeId(store.getStoreId())
                .address(store.getAddress())
                .build();
    }
}
