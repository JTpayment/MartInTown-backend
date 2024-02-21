package JTpayment.MartInTown.domain.register.presentation;

import JTpayment.MartInTown.domain.register.presentation.dto.request.CreateRegisterRequest;
import JTpayment.MartInTown.domain.register.presentation.dto.response.MyRegisterListResponse;
import JTpayment.MartInTown.domain.register.service.CreateRegisterService;
import JTpayment.MartInTown.domain.register.service.MyRegisterListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store/register")
public class RegisterController {

    private final CreateRegisterService createRegisterService;

    private final MyRegisterListService myRegisterListService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateRegisterRequest createRegisterRequest) {
        createRegisterService.execute(createRegisterRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<MyRegisterListResponse> list() {
        MyRegisterListResponse response = myRegisterListService.execute();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
