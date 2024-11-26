package umc.spring.workbook5.service.MemberService;

import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.web.dto.MemberRequestDTO;

import java.util.List;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDto request);

    public boolean isValid(List<Long> values);
}
