package umc.spring.workbook5.converter;

import jakarta.persistence.*;
import org.springframework.data.domain.Page;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.Review;
import umc.spring.workbook5.domain.ReviewImage;
import umc.spring.workbook5.domain.Store;
import umc.spring.workbook5.web.dto.ReviewRequestDTO;
import umc.spring.workbook5.web.dto.ReviewResponseDTO;
import umc.spring.workbook5.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.DoubleStream.builder;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewResultListDTO toReviewResultListDTO(Page<Review> reviewList) {
        List<ReviewResponseDTO.ReviewResultDTO> reviewResultDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewResultDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewResultListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewResultDTOList.size())
                .reviewList(reviewResultDTOList)
                .build();
    }


    //reviewRequest로 review 만들고 그에 따른 response로 만든 review 결과를 ReviewResultDTO로 반환
    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review review) {
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .member_name(review.getMember().getName())
                .title(review.getTitle())
                .content(review.getContent())
                .score(review.getScore())
                .store_name(review.getStore().getName())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewDTO reviewDTO, Member member, Store store) {
        return Review.builder()
                .title(reviewDTO.getTitle())
                .member(member)
                .score(reviewDTO.getScore())
                .store(store)
                .content(reviewDTO.getContent())
                .reviewImageList(toReviewImages(reviewDTO.getImages_url()))
                .build();
    }

    //toReviewImages() 메서드에 의해 호출됨
    public static ReviewImage toReviewImage(String reviewImageUrl) {
        return ReviewImage.builder()
                .imageUrl(reviewImageUrl)
                .build();
    }

    //reviewDTO로 받은 reviewImage인 List<String>을 ReviewImage 엔티티 리스트로 만들어서 Review 엔티티에 넣어야함
    // ->toReviewImages 메서드로 DTO로 받은 List의 각 String을 stream()으로 받아서 toReviewImage()메서드로 넘김
    // -> 인자로 받은 각 string을 reviewImageUrl 필드에 넣어 각 string마다 ReviewImage 객체로 반환
    // -> stream().map().toList() 메서드로 toReviewImage()가 반환한 ReviewImage 객체를 원소로하는 List<ReviewImage>만들어서 반환
    public static List<ReviewImage> toReviewImages(List<String> reviewImageUrls) {
        return reviewImageUrls.stream()
                .map(ReviewConverter::toReviewImage)
                .toList();
    }
}
