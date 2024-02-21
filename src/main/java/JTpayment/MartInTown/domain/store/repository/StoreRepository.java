package JTpayment.MartInTown.domain.store.repository;

import JTpayment.MartInTown.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
