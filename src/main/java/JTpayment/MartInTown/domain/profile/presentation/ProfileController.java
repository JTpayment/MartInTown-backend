package JTpayment.MartInTown.domain.profile.presentation;

import JTpayment.MartInTown.domain.profile.presentation.data.request.OwnStoreEditRequest;
import JTpayment.MartInTown.domain.profile.presentation.data.response.MyFavoriteStoreListResponse;
import JTpayment.MartInTown.domain.profile.presentation.data.response.OwnStoreDetailResponse;
import JTpayment.MartInTown.domain.profile.presentation.data.response.OwnStoreListResponse;
import JTpayment.MartInTown.domain.profile.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final FavoriteService favoriteService;
    private final FavoriteDelService favoriteDelService;
    private final MyFavoritesService myFavoritesService;
    private final OwnStoreService ownStoreService;
    private final OwnStoreDetailService ownStoreDetailService;
    private final OwnStoreDeleteService ownStoreDeleteService;
    private final OwnStoreEditService ownStoreEditService;


    @PostMapping("/favorite/{storeId}")
    public ResponseEntity<Void> favorite(@PathVariable Long storeId) {
        favoriteService.execute(storeId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/favorite/{storeId}")
    public ResponseEntity<Void> deleteFavoriteStore(@PathVariable Long storeId) {
        favoriteDelService.execute(storeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/favorite")
    public ResponseEntity<MyFavoriteStoreListResponse> getFavoriteStores() {
        MyFavoriteStoreListResponse res = myFavoritesService.execute();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/store-list")
    public ResponseEntity<OwnStoreListResponse> getOwnStoreList() {
        OwnStoreListResponse res = ownStoreService.execute();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/store-list/{storeId}")
    public ResponseEntity<OwnStoreDetailResponse> getOwnStoreList(@PathVariable Long storeId) {
        OwnStoreDetailResponse res = ownStoreDetailService.execute(storeId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/store-list/{storeId}")
    public ResponseEntity<Void> deleteOwnStore(@PathVariable Long storeId){
        ownStoreDeleteService.execute(storeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/store-list/{storeId}")
    public ResponseEntity<Void> editOwnStore(@PathVariable Long storeId,
                                             @RequestBody OwnStoreEditRequest request){
        ownStoreEditService.execute(storeId, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
