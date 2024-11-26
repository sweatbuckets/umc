package umc.spring.workbook5.repository.FoodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.workbook5.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {

}
