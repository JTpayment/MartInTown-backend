package JTpayment.MartInTown.domain.store.exception;

import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;

public class StoreNotfoundException extends BasicException {
    public StoreNotfoundException() {
        super(ErrorCode.STORE_NOT_FOUND);
    }
}