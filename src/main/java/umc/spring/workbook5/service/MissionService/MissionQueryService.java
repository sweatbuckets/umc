package umc.spring.workbook5.service.MissionService;

import org.springframework.stereotype.Service;
import umc.spring.workbook5.domain.Mission;
import umc.spring.workbook5.domain.Store;

import java.util.Optional;

@Service
public interface MissionQueryService {
    Optional<Mission> findMission(Long id);
}
