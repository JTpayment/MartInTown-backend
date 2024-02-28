package JTpayment.MartInTown.domain.auth.entity;

import JTpayment.MartInTown.domain.auth.entity.enums.Role;
import JTpayment.MartInTown.domain.profile.entity.MemberFavoriteStore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(name = "member_password", nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member")
    private Set<MemberFavoriteStore> memberStores = new HashSet<>();

    public void setRole(Role role) {
        this.role = role;
    }
}
