package JTpayment.MartInTown.domain.auth.service;

import JTpayment.MartInTown.domain.auth.presentation.data.request.MemberSignupRequest;

public interface MemberSignupService {
    void execute(MemberSignupRequest request);
}
