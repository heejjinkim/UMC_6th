package umc.spring.service.MissionService;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionService {
    public Mission createMission(MissionRequestDTO.CreateDTO request);
}