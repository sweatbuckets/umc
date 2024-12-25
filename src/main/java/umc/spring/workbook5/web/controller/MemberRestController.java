package umc.spring.workbook5.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.workbook5.apiPayload.ApiResponse;
import umc.spring.workbook5.converter.MemberConverter;
import umc.spring.workbook5.converter.MemberMissionConverter;
import umc.spring.workbook5.converter.ReviewConverter;
import umc.spring.workbook5.converter.StoreConverter;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.Mission;
import umc.spring.workbook5.domain.Review;
import umc.spring.workbook5.domain.mapping.MemberMission;
import umc.spring.workbook5.domain.mapping.MissionStatus;
import umc.spring.workbook5.service.MemberService.MemberCommandService;
import umc.spring.workbook5.service.MemberService.MemberQueryService;
import umc.spring.workbook5.service.StoreService.StoreQueryService;
import umc.spring.workbook5.web.dto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{member_id}/reviews")
    @Operation(summary = "특정 사용자의 리뷰 목록 조회 API",description = "특정 사용자의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "member_id", description = "사용자 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewResultListDTO> getReviewList(@PathVariable(name = "member_id") Long memberId, @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = memberQueryService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultListDTO(reviewList));
    }

    @GetMapping("/{member_id}/missions")
    @Operation(summary = "특정 사용자의 진행중인 미션 목록 조회 API",description = "특정 사용자의 진행중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "member_id", description = "사용자 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MemberMissionResultListDTO> getChallengingMemberMissionList(@PathVariable(name = "member_id") Long memberId, @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissionList = memberQueryService.getMemberMissionList(memberId, MissionStatus.CHALLENGING, page);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultListDTO(memberMissionList));
    }

    @GetMapping("/{member_id}/missions/completed")
    @Operation(summary = "특정 사용자의 완료한 미션 목록 조회 API",description = "특정 사용자의 완료한 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "member_id", description = "사용자 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MemberMissionResultListDTO> getCompleteMemberMissionList(@PathVariable(name = "member_id") Long memberId, @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissionList = memberQueryService.getMemberMissionList(memberId, MissionStatus.COMPLETE, page);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultListDTO(memberMissionList));
    }

}
