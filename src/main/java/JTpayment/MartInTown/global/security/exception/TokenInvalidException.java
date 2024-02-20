package JTpayment.MartInTown.global.security.exception;

import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;

public class TokenInvalidException extends BasicException {
    public TokenInvalidException() {
        super(ErrorCode.TOKEN_IS_INVALID);
    }
}
