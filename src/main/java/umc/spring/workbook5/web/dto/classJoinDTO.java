package umc.spring.workbook5.web.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class classJoinDTO {
    String name;
    Integer gender;
    Integer birthYear;
    Integer birthMonth;
    Integer birthDay;
    String address;
    String specAddress;
    List<Long> preferCategory;
}
