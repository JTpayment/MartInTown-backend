package JTpayment.MartInTown.domain.profile.presentation.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnStoreEditRequest {

    private String storeName;
    private String address;
}
