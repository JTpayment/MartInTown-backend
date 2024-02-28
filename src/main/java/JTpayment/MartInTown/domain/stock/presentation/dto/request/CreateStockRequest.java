package JTpayment.MartInTown.domain.stock.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateStockRequest {

    @NotBlank(message = "이름을 입력해주세요.")
    private String stockName;

    @NotBlank(message = "가격을 입력해주세요.")
    private int price;

    @NotBlank(message = "재고 수량을 입력해주세요.")
    private int stock;

    private String image;
}
