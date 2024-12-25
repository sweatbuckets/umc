package umc.spring.workbook5.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.Mission;
import umc.spring.workbook5.domain.Review;
import umc.spring.workbook5.domain.Store;
import umc.spring.workbook5.domain.mapping.MemberMission;
import umc.spring.workbook5.domain.mapping.MissionStatus;
import umc.spring.workbook5.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.workbook5.repository.MemberMissionRepository.MemberMissionRepositoryCustom;
import umc.spring.workbook5.repository.MemberRepository.MemberRepository;
import umc.spring.workbook5.repository.MissionRepository.MissionRepository;
import umc.spring.workbook5.repository.ReviewRepository.ReviewRepository;
import umc.spring.workbook5.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberMissionRepositoryCustom memberMissionRepositoryCustom;

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).orElse(null);

        Page<Review> reviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return reviewPage;
    }

    @Override
    public Page<MemberMission> getMemberMissionList(Long memberId, MissionStatus missionStatus, Integer page) {
        Page<MemberMission> memberMissionPage = memberMissionRepositoryCustom.findAllByMemberAndStatus(memberId, missionStatus, PageRequest.of(page, 10));
        return memberMissionPage;
    }
}
