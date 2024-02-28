package JTpayment.MartInTown.domain.profile.presentation.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnStoreListResponse {
    List<OwnStoreResponse> ownStoreList;
}
