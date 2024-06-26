package umc.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    @Query("SELECT mm FROM MemberMission mm JOIN FETCH mm.mission m WHERE m.id = :missionId AND mm.member.id = :memberId")
    Optional<MemberMission> findByMissionIdAndMemberId(Long missionId, Long memberId);
}