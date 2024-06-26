package umc.spring.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.repository.RegionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionServiceImpl implements RegionService{

    private final RegionRepository regionRepository;
    @Override
    public boolean existRegion(Long value) {
        return regionRepository.existsById(value);
    }
}
