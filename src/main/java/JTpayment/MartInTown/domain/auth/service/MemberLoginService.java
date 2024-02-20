package JTpayment.MartInTown.domain.auth.service;

import JTpayment.MartInTown.domain.auth.presentation.data.request.MemberLoginRequest;
import JTpayment.MartInTown.domain.auth.presentation.data.response.MemberLoginResponse;

public interface MemberLoginService {
    MemberLoginResponse execute(MemberLoginRequest request);
}
