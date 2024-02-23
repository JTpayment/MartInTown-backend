package JTpayment.MartInTown.domain.store.presentation;

import JTpayment.MartInTown.domain.store.presentation.dto.response.StoreListResponse;
import JTpayment.MartInTown.domain.store.service.StoreListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class StoreController {

    private final StoreListService storeListService;

    @GetMapping
    public ResponseEntity<StoreListResponse> list() {
        StoreListResponse response = storeListService.execute();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
