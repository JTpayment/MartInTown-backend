package JTpayment.MartInTown.domain.stock.presentation.dto.response;

import JTpayment.MartInTown.domain.stock.entity.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockResponse {

    private Long stockId;

    private String stockName;

    private int price;

    private int stock;

    private String image;

    public static StockResponse toResponse(Stock stock) {

        return StockResponse.builder()
                .stockId(stock.getStockId())
                .stockName(stock.getStockName())
                .price(stock.getPrice())
                .stock(stock.getStock())
                .image(stock.getImage())
                .build();
    }
}
