package umc.spring.workbook5.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.workbook5.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
