package JTpayment.MartInTown.domain.stock.exception;

import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;

public class StockNotFoundException extends BasicException {

    public StockNotFoundException() {
        super(ErrorCode.STOCK_NOT_FOUND);
    }
}
