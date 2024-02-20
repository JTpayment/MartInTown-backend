package JTpayment.MartInTown.global.error;

import lombok.Getter;

@Getter
public class BasicException extends RuntimeException{

    private ErrorCode errorCode;

    public BasicException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
