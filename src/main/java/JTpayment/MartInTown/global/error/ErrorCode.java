package JTpayment.MartInTown.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //S3
    FILE_UPLOAD_FAIL("파일 업로드에 실패했습니다.", 500),
    NOT_ALLOWED_FILE("허용되지 않은 파일 형식입니다.", 400),
    INVALID_FORMAT_FILE("잘못된 형식의 파일입니다.", 400);

    private final String message;
    private final int status;
}
