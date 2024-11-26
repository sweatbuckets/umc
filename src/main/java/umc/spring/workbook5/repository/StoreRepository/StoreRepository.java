package umc.spring.workbook5.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.workbook5.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {

}
