package JTpayment.MartInTown.global.util;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.stock.entity.Stock;
import JTpayment.MartInTown.domain.stock.exception.StockNotFoundException;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.domain.store.exception.ManagerMismatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockServiceUtil {

    private final StoreUtil storeUtil;

    private final MemberUtil memberUtil;

    private final StockUtil stockUtil;

    public void checkManagerAndStock(Long storeId, Long stockId) {

        Store store = storeUtil.findById(storeId);

        Member member = memberUtil.currentMember();

        if (!store.getManager().equals(member)) {
            throw new ManagerMismatchException();
        }

        Stock stock = stockUtil.findById(stockId);

        if (stock.getStore() != store) {
            throw new StockNotFoundException();
        }
    }
}
