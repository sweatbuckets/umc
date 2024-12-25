package umc.spring.workbook5.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.workbook5.domain.mapping.MissionStatus;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberMissionResultDTO{

        MissionStatus status;
        LocalDateTime deadline;
        Long missionId;
        String missionSpec;
        String storeName;
        LocalDateTime createdAt;

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberMissionResultListDTO{
        List<MemberMissionResultDTO> memberMissionResultList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

}
