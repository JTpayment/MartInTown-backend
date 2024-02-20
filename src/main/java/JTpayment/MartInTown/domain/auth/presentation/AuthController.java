package JTpayment.MartInTown.domain.auth.presentation;

import JTpayment.MartInTown.domain.auth.presentation.data.request.MemberLoginRequest;
import JTpayment.MartInTown.domain.auth.presentation.data.request.MemberSignupRequest;
import JTpayment.MartInTown.domain.auth.presentation.data.response.MemberLoginResponse;
import JTpayment.MartInTown.domain.auth.presentation.data.response.NewTokenResponse;
import JTpayment.MartInTown.domain.auth.service.MemberLoginService;
import JTpayment.MartInTown.domain.auth.service.MemberLogoutService;
import JTpayment.MartInTown.domain.auth.service.MemberSignupService;
import JTpayment.MartInTown.domain.auth.service.ReissueTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberSignupService memberSignupService;
    private final MemberLoginService memberLoginService;
    private final ReissueTokenService reissueTokenService;
    private final MemberLogoutService memberLogoutService;

    @PostMapping("/signup")
    public ResponseEntity<Void> memberSignup(@RequestBody @Valid MemberSignupRequest request) {
        memberSignupService.execute(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberLoginResponse> memberLogin(@RequestBody @Valid MemberLoginRequest request) {
        MemberLoginResponse response = memberLoginService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/reissue")
    public ResponseEntity<NewTokenResponse> reIssueToken(@RequestHeader("RefreshToken") String refreshToken) {
        NewTokenResponse newTokenResponse = reissueTokenService.execute(refreshToken);
        return new ResponseEntity<>(newTokenResponse, HttpStatus.OK);
    }

    @DeleteMapping("/logout")
    public ResponseEntity<Void> logout(
            @RequestHeader("AccessToken") String accessToken,
            @RequestHeader("RefreshToken") String refreshToken)
    {
        memberLogoutService.execute(accessToken, refreshToken);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
