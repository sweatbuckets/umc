package umc.spring.workbook5.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.workbook5.domain.Store;
@Repository
public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {

}
