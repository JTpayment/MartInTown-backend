package JTpayment.MartInTown.domain.register.service.impl;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.register.entity.Register;
import JTpayment.MartInTown.domain.register.presentation.dto.response.RegisterListResponse;
import JTpayment.MartInTown.domain.register.presentation.dto.response.RegisterResponse;
import JTpayment.MartInTown.domain.register.repository.RegisterRepository;
import JTpayment.MartInTown.domain.register.service.RegisterListService;
import JTpayment.MartInTown.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegisterListServiceImpl implements RegisterListService {

    private final RegisterRepository registerRepository;

    private final MemberUtil memberUtil;

    @Override
    public RegisterListResponse execute() {

        Member member = memberUtil.currentMember();

        List<Register> registerList = registerRepository.findByMemberId(member.getMemberId());

        return RegisterListResponse.builder()
                .registerList(
                        registerList.stream()
                                .map(RegisterResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
