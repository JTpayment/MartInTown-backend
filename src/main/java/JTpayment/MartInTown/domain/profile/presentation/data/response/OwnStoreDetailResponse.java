package JTpayment.MartInTown.domain.profile.presentation.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnStoreDetailResponse {

    private Long storeId;

    private String storeName;

    private String address;

    private String image;
}
