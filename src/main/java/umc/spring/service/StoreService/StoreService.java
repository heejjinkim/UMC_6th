package umc.spring.service.StoreService;
import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

import java.util.Optional;

public interface StoreService {

    public Store joinStore(StoreRequestDTO.JoinDto request);

    boolean existStore(Long value);

    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);

    Page<Mission> getMissionList(Long storeId, int page);
}