package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionServiceImpl implements MissionService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.CreateDTO request) {
        Mission mission = MissionConverter.toMission(request);
        mission.setStore(storeRepository.findById(request.getStoreId()).get());

        return missionRepository.save(mission);
    }
}
