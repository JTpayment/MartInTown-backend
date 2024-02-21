package JTpayment.MartInTown.global.util;

import JTpayment.MartInTown.domain.register.entity.Register;
import JTpayment.MartInTown.domain.register.exception.RegisterNotFoundException;
import JTpayment.MartInTown.domain.register.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUtil {

    private final RegisterRepository registerRepository;

    public Register findById(Long id) {
        return registerRepository.findById(id)
                .orElseThrow(RegisterNotFoundException::new);
    }
}
