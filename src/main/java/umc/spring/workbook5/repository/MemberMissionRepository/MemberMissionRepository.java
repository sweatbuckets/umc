package umc.spring.workbook5.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.workbook5.domain.mapping.MemberMission;
@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
