package umc.spring.workbook5.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.workbook5.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")

    private Review review;

    private String imageUrl;
}
