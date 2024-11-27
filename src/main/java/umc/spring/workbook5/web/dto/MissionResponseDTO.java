package umc.spring.workbook5.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.workbook5.domain.mapping.MissionStatus;

import java.time.LocalDateTime;

public class MissionResponseDTO {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberMissionResultDTO{

        MissionStatus status;

        LocalDateTime deadline;

        String store_name;

    }

}
