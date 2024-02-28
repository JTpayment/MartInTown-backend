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
public class MyFavoritesStoreResponse {
    private Long storeId;

    private String storeName;

    private String address;


    public static MyFavoritesStoreResponse toResponse(Store store) {
        return MyFavoritesStoreResponse.builder()
                .storeId(store.getStoreId())
                .storeName(store.getStoreName())
                .address(store.getAddress())
                .build();
    }
}
