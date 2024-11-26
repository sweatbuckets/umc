package umc.spring.workbook5.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.workbook5.apiPayload.ApiResponse;
import umc.spring.workbook5.service.StoreService.StoreCommandService;
import umc.spring.workbook5.web.dto.ReviewRequestDTO;
import umc.spring.workbook5.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/stores/{store_id}/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> createReview(@PathVariable("store_id") Long storeId, @RequestBody @Valid ReviewRequestDTO.ReviewDTO request){
        return ApiResponse.onSuccess(storeCommandService.createReview(request, storeId));
    }
}
