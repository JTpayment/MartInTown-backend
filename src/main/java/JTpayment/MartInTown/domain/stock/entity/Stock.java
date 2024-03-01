package JTpayment.MartInTown.domain.stock.entity;

import JTpayment.MartInTown.domain.stock.presentation.dto.request.UpdateStockRequest;
import JTpayment.MartInTown.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    @Column(nullable = false)
    private String stockName;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stock;

    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public void update(UpdateStockRequest request) {
        stockName = request.getStockName();
        price = request.getPrice();
        stock = request.getStock();
        image = request.getImage();
    }
}
