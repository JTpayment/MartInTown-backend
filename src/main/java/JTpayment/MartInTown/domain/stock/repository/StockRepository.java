package JTpayment.MartInTown.domain.stock.repository;

import JTpayment.MartInTown.domain.stock.entity.Stock;
import JTpayment.MartInTown.domain.store.entity.Store;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findByStore(Store store);

    @Query("select s from Stock s where s.store = :store and s.stockName like %:key%")
    List<Stock> findByStoreAndKey(@Param("store") Store store,@Param("key") String key);
}
