package JTpayment.MartInTown.domain.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RedisHash(value = "refreshToken")
public class RefreshToken {

    @Id
    private String loginId;

    @Indexed
    private String refreshToken;

    @TimeToLive
    private Long expiredAt;

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
