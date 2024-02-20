package JTpayment.MartInTown.global.security.exception;

import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;

public class TokenExpiredException extends BasicException {

    public TokenExpiredException() {
        super(ErrorCode.TOKEN_IS_EXPIRED);
    }
}
