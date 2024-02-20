package JTpayment.MartInTown.domain.file.exception;

import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;

public class InvalidFormatFileException extends BasicException {

    public InvalidFormatFileException() {
        super(ErrorCode.INVALID_FORMAT_FILE);
    }
}
