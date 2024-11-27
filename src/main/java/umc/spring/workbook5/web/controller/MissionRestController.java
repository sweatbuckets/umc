package umc.spring.workbook5.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.workbook5.apiPayload.ApiResponse;
import umc.spring.workbook5.service.MissionService.MissionCommandService;
import umc.spring.workbook5.web.dto.MissionRequestDTO;
import umc.spring.workbook5.web.dto.MissionResponseDTO;
import umc.spring.workbook5.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/{mission_id}")
    public ApiResponse<MissionResponseDTO.MemberMissionResultDTO> missionChallenge(@PathVariable("mission_id") Long missionId, @RequestBody @Valid MissionRequestDTO.MemberMissionDTO request) {
        return ApiResponse.onSuccess(missionCommandService.missionChallenge(request, missionId));
    }
}
