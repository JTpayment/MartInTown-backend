package JTpayment.MartInTown.domain.profile.exception;

import JTpayment.MartInTown.global.error.BasicException;
import JTpayment.MartInTown.global.error.ErrorCode;

public class DuplicatedFavoriteStoreException extends BasicException {
    public DuplicatedFavoriteStoreException() {
        super(ErrorCode.DUPLICATED_FAVORITE_STORE);
    }
}
