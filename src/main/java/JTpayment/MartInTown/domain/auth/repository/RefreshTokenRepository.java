package JTpayment.MartInTown.domain.auth.repository;

import JTpayment.MartInTown.domain.auth.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
    RefreshToken findByRefreshToken(String token);
}
