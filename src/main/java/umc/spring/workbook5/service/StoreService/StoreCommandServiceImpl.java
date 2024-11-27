package umc.spring.workbook5.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.workbook5.converter.ReviewConverter;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.Review;
import umc.spring.workbook5.domain.Store;
import umc.spring.workbook5.repository.MemberRepository.MemberRepository;
import umc.spring.workbook5.repository.ReviewRepository.ReviewRepository;
import umc.spring.workbook5.repository.StoreRepository.StoreRepository;
import umc.spring.workbook5.web.dto.ReviewRequestDTO;
import umc.spring.workbook5.web.dto.ReviewResponseDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public ReviewResponseDTO.ReviewResultDTO createReview(ReviewRequestDTO.ReviewDTO requestDTO, Long storeId) {
        //1.storeId가 존재하는지 storeRepository에서 findById로 검색 - 유효성 검사
        Optional<Store> store = storeRepository.findById(storeId);
        Optional<Member> member = memberRepository.findById(requestDTO.getMember_id());

        //2. converter를 통해서 requestDTO를 review로 변환해서 객체 생성
        Review review = ReviewConverter.toReview(requestDTO, member.get(), store.get());
        reviewRepository.save(review);

        //3. 변환한 review를 reponseDTP로 변환하여 return
        return  ReviewConverter.toReviewResultDTO(review);
    }
}
