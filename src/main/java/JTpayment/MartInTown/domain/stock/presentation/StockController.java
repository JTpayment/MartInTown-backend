package JTpayment.MartInTown.domain.stock.presentation;

import JTpayment.MartInTown.domain.stock.presentation.dto.request.CreateStockRequest;
import JTpayment.MartInTown.domain.stock.presentation.dto.response.StockListResponse;
import JTpayment.MartInTown.domain.stock.service.CreateStockService;
import JTpayment.MartInTown.domain.stock.service.StockListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock/{storeId}")
public class StockController {

    private final CreateStockService createStockService;

    private final StockListService stockListService;

    @PostMapping
    public ResponseEntity<Void> create(
            @PathVariable @Valid Long storeId,
            @RequestBody CreateStockRequest createStockRequest
    ) {
      createStockService.execute(storeId, createStockRequest);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<StockListResponse> list(@PathVariable @Valid Long storeId) {
        StockListResponse response = stockListService.execute(storeId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
