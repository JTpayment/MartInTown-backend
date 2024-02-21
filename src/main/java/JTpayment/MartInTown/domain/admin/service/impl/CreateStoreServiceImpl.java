package JTpayment.MartInTown.domain.admin.service.impl;

import JTpayment.MartInTown.domain.admin.service.CreateStoreService;
import JTpayment.MartInTown.domain.auth.entity.Member;
import JTpayment.MartInTown.domain.register.entity.Register;
import JTpayment.MartInTown.domain.register.entity.enums.Status;
import JTpayment.MartInTown.domain.register.repository.RegisterRepository;
import JTpayment.MartInTown.domain.store.entity.Store;
import JTpayment.MartInTown.domain.store.repository.StoreRepository;
import JTpayment.MartInTown.global.annotation.ServiceWithTransactional;
import JTpayment.MartInTown.global.util.MemberUtil;
import JTpayment.MartInTown.global.util.RegisterUtil;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class CreateStoreServiceImpl implements CreateStoreService {

    private final RegisterUtil registerUtil;

    private final MemberUtil memberUtil;

    private final StoreRepository storeRepository;

    private final RegisterRepository registerRepository;

    @Override
    public void execute(Long registerId) {

        Register register = registerUtil.findById(registerId);

        Member member = memberUtil.findById(register.getMemberId());

        Store store = Store.builder()
                .manager(member)
                .storeName(register.getStoreName())
                .address(register.getAddress())
                .image(register.getImage())
                .build();

        storeRepository.save(store);

        register.setStatus(Status.OK);
        registerRepository.save(register);
    }
}
