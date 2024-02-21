package JTpayment.MartInTown.domain.register.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyRegisterListResponse {

    private List<MyRegisterResponse> registerList;
}
