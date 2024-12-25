package umc.spring.workbook5.converter;

import jakarta.persistence.*;
import org.springframework.data.domain.Page;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.Mission;
import umc.spring.workbook5.domain.Review;
import umc.spring.workbook5.domain.Store;
import umc.spring.workbook5.domain.mapping.MemberMission;
import umc.spring.workbook5.domain.mapping.MissionStatus;
import umc.spring.workbook5.web.dto.MemberResponseDTO;
import umc.spring.workbook5.web.dto.MissionRequestDTO;
import umc.spring.workbook5.web.dto.MissionResponseDTO;
import umc.spring.workbook5.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
                .missionId(memberMission.getMission().getId())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .storeName(memberMission.getMission().getStore().getName())
                .deadline(memberMission.getMission().getDeadline())
                .createdAt(memberMission.getMission().getCreatedAt())
                .status(memberMission.getStatus())
                .build();
    }

    public static MissionResponseDTO.MemberMissionResultListDTO toMemberMissionResultListDTO(Page<MemberMission> memberMissionList){
        List<MissionResponseDTO.MemberMissionResultDTO> memberMissionResultDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::toMemberMissionResultDTO).collect(Collectors.toList());

        return MissionResponseDTO.MemberMissionResultListDTO.builder()
                .isFirst(memberMissionList.isFirst())
                .isLast(memberMissionList.isLast())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(memberMissionResultDTOList.size())
                .memberMissionResultList(memberMissionResultDTOList)
                .build();
    }
}
