package JTpayment.MartInTown.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //TOKEN
    TOKEN_IS_EXPIRED("토큰이 만료 되었습니다.", 403),
    TOKEN_IS_INVALID("토큰이 유효 하지 않습니다.", 401),

    //MEMBER
    DUPLICATED_ID("중복된 아이디 입니다.", 409),
    DUPLICATED_EMAIL("중복된 이메일 입니다.", 409),
    MEMBER_NOT_FOUND("등록되지 않은 유저입니다.", 404),
    PASSWORD_INVALID("비밀번호가 일치하지 않습니다.", 403),

    //S3
    FILE_UPLOAD_FAIL("파일 업로드에 실패했습니다.", 500),
    NOT_ALLOWED_FILE("허용되지 않은 파일 형식입니다.", 400),
    INVALID_FORMAT_FILE("잘못된 형식의 파일입니다.", 400),

    //REGISTER
    REGISTER_NOT_FOUND("점포 신청을 찾을 수 없습니다.", 404),
    STORE_NOT_FOUND("점포를 찾을 수 없습니다.", 404),
    DUPLICATED_FAVORITE_STORE("중복된 단골점포 입니다.", 409),
    FAVORITE_STORE_NOT_FOUND("단골 점포를 찾을 수 없습니다.", 404);

    private final String message;
    private final int status;
}
