package umc.spring.workbook5.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.workbook5.apiPayload.ApiResponse;
import umc.spring.workbook5.converter.MemberConverter;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.service.MemberService.MemberCommandService;
import umc.spring.workbook5.web.dto.MemberRequestDTO;
import umc.spring.workbook5.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
