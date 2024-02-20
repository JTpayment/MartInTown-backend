package JTpayment.MartInTown.domain.auth.exception;

import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;

public class MemberNotfoundException extends BasicException {
    public MemberNotfoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}
