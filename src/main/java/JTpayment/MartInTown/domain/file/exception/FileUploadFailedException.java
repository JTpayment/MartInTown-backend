package JTpayment.MartInTown.domain.file.exception;

import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;

public class FileUploadFailedException extends BasicException {

    public FileUploadFailedException() {
        super(ErrorCode.FILE_UPLOAD_FAIL);
    }
}
