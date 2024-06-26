package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionServiceImpl implements MissionService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.CreateDTO request) {
        Mission mission = MissionConverter.toMission(request);
        mission.setStore(storeRepository.findById(request.getStoreId()).get());

        return missionRepository.save(mission);
    }

    @Override
    @Transactional
    public MemberMission challengeMission(MissionRequestDTO.ChallengeDTO request) {
        MemberMission memberMission = MissionConverter.toMemberMission();
        memberMission.setMember(memberRepository.findById(request.getMemberId()).get());
        memberMission.setMission(missionRepository.findById(request.getMissionId()).get());

        return memberMissionRepository.save(memberMission);
    }

    @Override
    public boolean existMission(Long value) {
        return missionRepository.existsById(value);
    }

    @Override
    public boolean isChallengingMission(Long memberId, Long missionId) {
        return memberMissionRepository.findByMissionIdAndMemberId(missionId, memberId)
                .map(memberMission -> memberMission.getStatus().name().equals("CHALLENGING"))
                .orElse(false);
    }
}
