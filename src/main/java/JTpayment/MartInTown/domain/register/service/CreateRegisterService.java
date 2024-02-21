package JTpayment.MartInTown.domain.register.service;

import JTpayment.MartInTown.domain.register.presentation.dto.request.CreateRegisterRequest;

public interface CreateRegisterService {

    void execute(CreateRegisterRequest createRegisterRequest);
}
