package JTpayment.MartInTown.domain.stock.presentation;

import JTpayment.MartInTown.domain.stock.presentation.dto.request.CreateStockRequest;
import JTpayment.MartInTown.domain.stock.presentation.dto.request.UpdateStockRequest;
import JTpayment.MartInTown.domain.stock.presentation.dto.response.StockListResponse;
import JTpayment.MartInTown.domain.stock.service.*;
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

    private final SearchStockService searchStockService;

    private final DeleteStockService deleteStockService;

    private final UpdateStockService updateStockService;

    @PostMapping
    public ResponseEntity<Void> create(
            @PathVariable Long storeId,
            @RequestBody CreateStockRequest createStockRequest
    ) {
      createStockService.execute(storeId, createStockRequest);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<StockListResponse> list(@PathVariable Long storeId) {
        StockListResponse response = stockListService.execute(storeId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<StockListResponse> search(@PathVariable Long storeId, @RequestParam String key) {
        StockListResponse response = searchStockService.execute(storeId, key);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{stockId}")
    public ResponseEntity<Void> delete(@PathVariable Long storeId, @PathVariable Long stockId) {
        deleteStockService.execute(storeId, stockId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{stockId}")
    public ResponseEntity<Void> update(
            @PathVariable Long storeId,
            @PathVariable Long stockId,
            @RequestBody UpdateStockRequest updateStockRequest
    ) {
        updateStockService.execute(storeId, stockId, updateStockRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
