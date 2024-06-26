package umc.spring.service.MissionService;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionService {
    public Mission createMission(MissionRequestDTO.CreateDTO request);
    public MemberMission challengeMission(MissionRequestDTO.ChallengeDTO request);

    boolean existMission(Long value);

    boolean isChallengingMission(Long memberId, Long missionId);
}