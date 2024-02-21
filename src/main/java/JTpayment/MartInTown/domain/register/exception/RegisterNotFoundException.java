package JTpayment.MartInTown.domain.register.exception;

import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;

public class RegisterNotFoundException extends BasicException {

    public RegisterNotFoundException() {
        super(ErrorCode.REGISTER_NOT_FOUND);
    }
}
