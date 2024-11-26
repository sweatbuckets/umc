package umc.spring.workbook5.apiPayload.exception.handler;

import umc.spring.workbook5.apiPayload.code.BaseErrorCode;
import umc.spring.workbook5.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
  public FoodCategoryHandler(BaseErrorCode errorCode) {
    super(errorCode);
  }
}
