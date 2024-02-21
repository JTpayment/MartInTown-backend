package JTpayment.MartInTown.domain.register.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {

    CHECKING, OK, REFUSE;

    @JsonCreator
    public static Status from(String s) {
        return Status.valueOf(s.toUpperCase());
    }
}
