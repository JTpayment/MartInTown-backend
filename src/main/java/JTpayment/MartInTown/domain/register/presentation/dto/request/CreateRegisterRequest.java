package JTpayment.MartInTown.domain.register.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateRegisterRequest {

    @NotBlank(message = "이름을 입력해주세요.")
    private String storeName;

    @NotBlank(message = "주소를 입력해주세요.")
    private String address;

    private String image;
}
