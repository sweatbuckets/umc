package umc.spring.workbook5.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.workbook5.domain.Member;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
