package umc.spring.workbook5.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.workbook5.converter.MemberMissionConverter;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.Mission;
import umc.spring.workbook5.domain.Store;
import umc.spring.workbook5.domain.mapping.MemberMission;
import umc.spring.workbook5.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.workbook5.repository.MemberRepository.MemberRepository;
import umc.spring.workbook5.repository.MissionRepository.MissionRepository;
import umc.spring.workbook5.repository.StoreRepository.StoreRepository;
import umc.spring.workbook5.service.StoreService.StoreCommandService;
import umc.spring.workbook5.service.StoreService.StoreQueryService;
import umc.spring.workbook5.web.dto.MissionRequestDTO;
import umc.spring.workbook5.web.dto.MissionResponseDTO;

import java.util.Optional;

import static umc.spring.workbook5.domain.QMember.member;


@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MissionResponseDTO.MemberMissionResultDTO missionChallenge(MissionRequestDTO.MemberMissionDTO requestDTO, Long missionId){

        Optional<Mission> mission = missionRepository.findById(missionId);
        Optional<Member> member = memberRepository.findById(requestDTO.getMember_id());

        MemberMission memberMission = MemberMissionConverter.toMemberMission(requestDTO, mission.get(), member.get());
        memberMissionRepository.save(memberMission);
        return MemberMissionConverter.toMemberMissionResultDTO(memberMission);
    }
}


