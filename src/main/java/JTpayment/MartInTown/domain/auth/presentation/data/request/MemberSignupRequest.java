package JTpayment.MartInTown.domain.auth.presentation.data.request;

import JTpayment.MartInTown.domain.auth.entity.enums.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MemberSignupRequest {
    @NotBlank(message = "공백이거나 중복인 아이디는 사용불가합니다.")
    private String id;

    @NotBlank(message = "지정된 형식에 맞춰 비밀번호를 입력해 주세요.")
    private String password;

    @NotBlank(message = "공백이거나 중복된 이메일은 사용불가합니다.")
    private String email;

    private Role role;
}
