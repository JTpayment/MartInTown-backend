package JTpayment.MartInTown.domain.register.entity;

import JTpayment.MartInTown.domain.register.entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registerId;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private String address;

    private String image;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }
}
