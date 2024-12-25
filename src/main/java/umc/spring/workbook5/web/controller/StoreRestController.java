package umc.spring.workbook5.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.workbook5.apiPayload.ApiResponse;
import umc.spring.workbook5.converter.StoreConverter;
import umc.spring.workbook5.domain.Mission;
import umc.spring.workbook5.domain.Review;
import umc.spring.workbook5.service.StoreService.StoreCommandService;
import umc.spring.workbook5.service.StoreService.StoreQueryService;
import umc.spring.workbook5.web.dto.ReviewRequestDTO;
import umc.spring.workbook5.web.dto.ReviewResponseDTO;
import umc.spring.workbook5.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/{store_id}/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> createReview(@PathVariable("store_id") Long storeId, @RequestBody @Valid ReviewRequestDTO.ReviewDTO request){
        return ApiResponse.onSuccess(storeCommandService.createReview(request, storeId));
    }

    @GetMapping("/{store_id}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "store_id", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@PathVariable(name = "store_id") Long storeId, @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.toReviewPreViewListDTO(reviewList));
    }

    @GetMapping("/{store_id}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게의 미션 목록을 조회하는 API이며 페이징을 포함, query String으로 page 번호 주세요")
    @Parameters({
            @Parameter(name = "store_id", description = "가게의 아이디, path variable 입니다")
    })
    public ApiResponse<StoreResponseDTO.MissionResultListDTO> getMissionList(@PathVariable(name = "store_id") Long storeId, @RequestParam(name = "page") Integer page){
        Page<Mission> missionList = storeQueryService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.toMissionResultListDTO(missionList));
    }
}
