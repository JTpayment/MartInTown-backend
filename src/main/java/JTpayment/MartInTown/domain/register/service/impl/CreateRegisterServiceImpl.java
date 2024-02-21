package JTpayment.MartInTown.domain.register.service.impl;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.register.entity.Register;
import JTpayment.MartInTown.domain.register.entity.enums.Status;
import JTpayment.MartInTown.domain.register.presentation.dto.request.CreateRegisterRequest;
import JTpayment.MartInTown.domain.register.repository.RegisterRepository;
import JTpayment.MartInTown.domain.register.service.CreateRegisterService;
import JTpayment.MartInTown.global.annotation.ServiceWithTransactional;
import JTpayment.MartInTown.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class CreateRegisterServiceImpl implements CreateRegisterService {

    private final RegisterRepository registerRepository;

    private final MemberUtil memberUtil;

    @Override
    public void execute(CreateRegisterRequest createRegisterRequest) {

        Member member = memberUtil.currentMember();

        Register register = Register.builder()
                .memberId(member.getMemberId())
                .storeName(createRegisterRequest.getStoreName())
                .address(createRegisterRequest.getAddress())
                .image(createRegisterRequest.getImage())
                .status(Status.CHECKING)
                .build();

        registerRepository.save(register);
    }
}
