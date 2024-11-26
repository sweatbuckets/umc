package umc.spring.workbook5.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.workbook5.domain.common.BaseEntity;
import umc.spring.workbook5.domain.enums.FoodType;
import umc.spring.workbook5.domain.mapping.MemberPrefer;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodType;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

}
