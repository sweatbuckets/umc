package umc.spring.workbook5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.workbook5.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
