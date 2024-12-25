package umc.spring.workbook5.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.Mission;
import umc.spring.workbook5.domain.Store;
import umc.spring.workbook5.domain.mapping.MemberMission;
import umc.spring.workbook5.domain.mapping.MissionStatus;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Page<MemberMission> findAllByStatus(MissionStatus missionStatus, PageRequest pageRequest);
    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);
}
