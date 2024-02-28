package JTpayment.MartInTown.domain.profile.exception;

import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;

public class FavoriteStoreNotfoundException extends BasicException {
    public FavoriteStoreNotfoundException() {
        super(ErrorCode.FAVORITE_STORE_NOT_FOUND);
    }
}
