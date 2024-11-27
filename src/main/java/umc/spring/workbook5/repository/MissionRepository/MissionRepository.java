package umc.spring.workbook5.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.workbook5.domain.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
}
