package umc.spring.workbook5.web.dto;

import jakarta.persistence.*;
import lombok.Getter;
import umc.spring.workbook5.domain.Member;
import umc.spring.workbook5.domain.ReviewImage;
import umc.spring.workbook5.domain.Store;

import java.util.ArrayList;
import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDTO{

        Long member_id;
        String store_name;
        String title;
        String content;
        Float score;


        List<String> images_url;

    }
}
