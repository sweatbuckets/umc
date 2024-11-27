package umc.spring.workbook5.converter;

import jakarta.persistence.*;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.Mission;
import umc.spring.workbook5.domain.Review;
import umc.spring.workbook5.domain.Store;
import umc.spring.workbook5.domain.mapping.MemberMission;
import umc.spring.workbook5.domain.mapping.MissionStatus;
import umc.spring.workbook5.web.dto.MissionRequestDTO;
import umc.spring.workbook5.web.dto.MissionResponseDTO;
import umc.spring.workbook5.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    //MemberMissionRequest로 MemberMission 만들고 그에 따른 response로 만든 review 결과를 memberMissionResultDTO로 반환
    public static MemberMission toMemberMission(MissionRequestDTO.MemberMissionDTO memberMissionDTO, Mission mission, Member member) {
        return MemberMission.builder()
                .mission(mission)
                .member(member)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MissionResponseDTO.MemberMissionResultDTO toMemberMissionResultDTO(MemberMission memberMission) {
        return MissionResponseDTO.MemberMissionResultDTO.builder()
                .store_name(memberMission.getMission().getStore().getName())
                .deadline(memberMission.getMission().getDeadline())
                .status(memberMission.getStatus())
                .build();
    }

}
