package umc.spring.workbook5.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.workbook5.apiPayload.code.status.ErrorStatus;
import umc.spring.workbook5.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.workbook5.converter.MemberConverter;
import umc.spring.workbook5.converter.MemberPreferConverter;
import umc.spring.workbook5.domain.FoodCategory;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.mapping.MemberPrefer;
import umc.spring.workbook5.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.spring.workbook5.repository.MemberRepository.MemberRepository;
import umc.spring.workbook5.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    public boolean isValid(List<Long> values){
        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryRepository.existsById(value));
        return isValid;

    }
}