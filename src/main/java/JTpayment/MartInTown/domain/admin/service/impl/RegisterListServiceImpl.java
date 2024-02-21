package JTpayment.MartInTown.domain.admin.service.impl;

import JTpayment.MartInTown.domain.admin.presentation.dto.response.RegisterListResponse;
import JTpayment.MartInTown.domain.admin.presentation.dto.response.RegisterResponse;
import JTpayment.MartInTown.domain.admin.service.RegisterListService;
import JTpayment.MartInTown.domain.register.entity.Register;
import JTpayment.MartInTown.domain.register.repository.RegisterRepository;
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

    @Override
    public RegisterListResponse execute() {

        List<Register> registerList = registerRepository.findAll();

        return RegisterListResponse.builder()
                .registerList(
                        registerList.stream()
                                .map(RegisterResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
