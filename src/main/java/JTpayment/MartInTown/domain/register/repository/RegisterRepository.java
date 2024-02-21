package JTpayment.MartInTown.domain.register.repository;

import JTpayment.MartInTown.domain.register.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterRepository extends JpaRepository<Register, Long> {

    List<Register> findByMemberId(Long id);
}
