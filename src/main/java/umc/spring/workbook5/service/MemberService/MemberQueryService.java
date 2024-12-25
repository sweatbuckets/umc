package umc.spring.workbook5.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.workbook5.domain.Mission;
import umc.spring.workbook5.domain.Review;
import umc.spring.workbook5.domain.enums.MemberStatus;
import umc.spring.workbook5.domain.mapping.MemberMission;
import umc.spring.workbook5.domain.mapping.MissionStatus;

public interface MemberQueryService {
    Page<Review> getReviewList(Long memberId, Integer page);
    Page<MemberMission> getMemberMissionList(Long memberId, MissionStatus status, Integer page);
}
