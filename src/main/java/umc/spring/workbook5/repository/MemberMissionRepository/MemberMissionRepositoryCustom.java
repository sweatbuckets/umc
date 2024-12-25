package umc.spring.workbook5.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import umc.spring.workbook5.domain.Store;
import umc.spring.workbook5.domain.mapping.MemberMission;
import umc.spring.workbook5.domain.mapping.MissionStatus;

import java.util.List;
@Repository
public interface MemberMissionRepositoryCustom {
    Page<MemberMission> findAllByMemberAndStatus(Long memberId, MissionStatus missionStatus, PageRequest pageRequest);

}
