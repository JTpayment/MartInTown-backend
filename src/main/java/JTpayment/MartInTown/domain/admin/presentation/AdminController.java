package JTpayment.MartInTown.domain.admin.presentation;

import JTpayment.MartInTown.domain.admin.presentation.dto.response.RegisterListResponse;
import JTpayment.MartInTown.domain.admin.service.CreateStoreService;
import JTpayment.MartInTown.domain.admin.service.RegisterListService;
import JTpayment.MartInTown.domain.admin.service.RegisterRefuseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final RegisterListService registerListService;

    private final RegisterRefuseService registerRefuseService;

    private final CreateStoreService createStoreService;

    @GetMapping("/register/list")
    public ResponseEntity<RegisterListResponse> list() {
        RegisterListResponse response = registerListService.execute();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/register/{registerId}")
    public ResponseEntity<Void> refuse(@PathVariable @Valid Long registerId) {
        registerRefuseService.execute(registerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register/{registerId}")
    public ResponseEntity<Void> createStore(@PathVariable @Valid Long registerId) {
        createStoreService.execute(registerId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
