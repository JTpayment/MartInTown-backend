package JTpayment.MartInTown.domain.store.entity;

import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.profile.entity.MemberFavoriteStore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "store")
    private Set<MemberFavoriteStore> memberStores = new HashSet<>();

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
