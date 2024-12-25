package umc.spring.workbook5.converter;

import org.springframework.data.domain.Page;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.Mission;
import umc.spring.workbook5.domain.enums.Gender;
import umc.spring.workbook5.web.dto.MemberRequestDTO;
import umc.spring.workbook5.web.dto.MemberResponseDTO;
import umc.spring.workbook5.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MissionResultDTO toMissionResultDTO(Mission mission){
        return MemberResponseDTO.MissionResultDTO.builder()
                .id(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .storeName(mission.getStore().getName())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }

    public static MemberResponseDTO.MissionResultListDTO toMissionResultListDTO(Page<Mission> missionList){
        List<MemberResponseDTO.MissionResultDTO> missionResultDTOList = missionList.stream()
                .map(MemberConverter::toMissionResultDTO).collect(Collectors.toList());

        return MemberResponseDTO.MissionResultListDTO.builder()
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionResultDTOList.size())
                .missionResultList(missionResultDTOList)
                .build();
    }
}
