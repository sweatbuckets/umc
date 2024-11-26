package umc.spring.workbook5.repository.StoreRepository;

import umc.spring.workbook5.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
