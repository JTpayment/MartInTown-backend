package JTpayment.MartInTown.domain.admin.presentation.dto.response;

import JTpayment.MartInTown.domain.register.entity.Register;
import JTpayment.MartInTown.domain.register.entity.enums.Status;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {

    private Long registerId;

    private String storeName;

    private String address;

    private String image;

    private Status status;

    public static RegisterResponse toResponse(Register register) {

        return RegisterResponse.builder()
                .registerId(register.getRegisterId())
                .storeName(register.getStoreName())
                .address(register.getAddress())
                .image(register.getImage())
                .status(register.getStatus())
                .build();
    }
}
