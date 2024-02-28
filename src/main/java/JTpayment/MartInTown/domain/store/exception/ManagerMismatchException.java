package JTpayment.MartInTown.domain.store.exception;

import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;

public class ManagerMismatchException extends BasicException {

    public ManagerMismatchException() {
        super(ErrorCode.MANAGER_MISMATCH);
    }
}
