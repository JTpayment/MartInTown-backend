package JTpayment.MartInTown.global.util;

import JTpayment.MartInTown.domain.stock.entity.Stock;
import JTpayment.MartInTown.domain.stock.exception.StockNotFoundException;
import JTpayment.MartInTown.domain.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockUtil {

    private final StockRepository stockRepository;

    public Stock findById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(StockNotFoundException::new);
    }
}
