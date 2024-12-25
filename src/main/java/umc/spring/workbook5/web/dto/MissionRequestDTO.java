package umc.spring.workbook5.web.dto;

import jakarta.persistence.*;
import lombok.Getter;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.Mission;
import umc.spring.workbook5.domain.Store;
import umc.spring.workbook5.domain.mapping.MemberMission;
import umc.spring.workbook5.domain.mapping.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class  MissionRequestDTO {

    @Getter
    public static class MemberMissionDTO{
        MissionStatus status;

        Long member_id;

        Long mission_id;
    }

}
