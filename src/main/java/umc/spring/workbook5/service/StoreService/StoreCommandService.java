package umc.spring.workbook5.service.StoreService;

import org.springframework.stereotype.Service;
import umc.spring.workbook5.web.dto.ReviewRequestDTO;
import umc.spring.workbook5.web.dto.ReviewResponseDTO;
@Service
public interface StoreCommandService {
    public ReviewResponseDTO.ReviewResultDTO createReview(ReviewRequestDTO.ReviewDTO requestDTO, Long storeId);
}
