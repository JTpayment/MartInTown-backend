package JTpayment.MartInTown.domain.store.entity;

import JTpayment.MartInTown.domain.auth.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member manager;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private String address;

    private String image;
}
