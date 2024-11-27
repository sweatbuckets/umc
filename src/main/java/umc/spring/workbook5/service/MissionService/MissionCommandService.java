package umc.spring.workbook5.service.MissionService;

import org.springframework.stereotype.Service;
import umc.spring.workbook5.web.dto.MissionRequestDTO;
import umc.spring.workbook5.web.dto.MissionResponseDTO;

@Service
public interface MissionCommandService {
    public MissionResponseDTO.MemberMissionResultDTO missionChallenge(MissionRequestDTO.MemberMissionDTO requestDTO, Long mission_id);
}
