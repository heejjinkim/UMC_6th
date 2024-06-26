package umc.spring.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinDto request) {
        Store newStore = StoreConverter.toStore(request);
        newStore.setRegion(regionRepository.findById(request.getRegionId()).get());
        return storeRepository.save(newStore);
    }
}