package JTpayment.MartInTown.domain.admin.service.impl;

import JTpayment.MartInTown.domain.admin.service.RegisterRefuseService;
import JTpayment.MartInTown.domain.register.entity.Register;
import JTpayment.MartInTown.domain.register.entity.enums.Status;
import JTpayment.MartInTown.domain.register.repository.RegisterRepository;
import JTpayment.MartInTown.global.annotation.ServiceWithTransactional;
import JTpayment.MartInTown.global.util.RegisterUtil;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class RegisterRefuseServiceImpl implements RegisterRefuseService {

    private final RegisterRepository registerRepository;

    private final RegisterUtil registerUtil;

    @Override
    public void execute(Long registerId) {

        Register register = registerUtil.findById(registerId);
        register.setStatus(Status.REFUSE);

        registerRepository.save(register);
    }
}
