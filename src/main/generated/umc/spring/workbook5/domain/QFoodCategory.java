package umc.spring.workbook5.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodCategory is a Querydsl query type for FoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodCategory extends EntityPathBase<FoodCategory> {

    private static final long serialVersionUID = -1024867531L;

    public static final QFoodCategory foodCategory = new QFoodCategory("foodCategory");

    public final umc.spring.workbook5.domain.common.QBaseEntity _super = new umc.spring.workbook5.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath foodType = createString("foodType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.workbook5.domain.mapping.MemberPrefer, umc.spring.workbook5.domain.mapping.QMemberPrefer> memberPreferList = this.<umc.spring.workbook5.domain.mapping.MemberPrefer, umc.spring.workbook5.domain.mapping.QMemberPrefer>createList("memberPreferList", umc.spring.workbook5.domain.mapping.MemberPrefer.class, umc.spring.workbook5.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFoodCategory(String variable) {
        super(FoodCategory.class, forVariable(variable));
    }

    public QFoodCategory(Path<? extends FoodCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodCategory(PathMetadata metadata) {
        super(FoodCategory.class, metadata);
    }

}

