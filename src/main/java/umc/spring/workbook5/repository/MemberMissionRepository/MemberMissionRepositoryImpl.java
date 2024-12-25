package umc.spring.workbook5.repository.MemberMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.QStore;
import umc.spring.workbook5.domain.Store;
import umc.spring.workbook5.domain.mapping.MemberMission;
import umc.spring.workbook5.domain.mapping.MissionStatus;
import umc.spring.workbook5.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public Page<MemberMission> findAllByMemberAndStatus(Long memberId, MissionStatus missionStatus, PageRequest pageRequest) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (memberId != null) {
            predicate.and(memberMission.member.id.eq(memberId));
        }

        if (missionStatus != null) {
            if (missionStatus == MissionStatus.COMPLETE) {
                predicate.and(memberMission.status.eq(MissionStatus.COMPLETE));
            } else
                predicate.and(memberMission.status.eq(MissionStatus.CHALLENGING));

        }

        List<MemberMission> memberMissionList = jpaQueryFactory
                .selectFrom(memberMission)
                .where(predicate)
                .fetch();

        return new PageImpl<>(memberMissionList, pageRequest, memberMissionList.size());
    }
}
