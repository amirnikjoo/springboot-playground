package com.amir.levant.core;

import com.amir.levant.dto.ResponseDto;

import java.util.Date;

public class Constants {
    public final static String REF_NO = "REF_NO";

    public static final String EXCEPTION_SOURCE_ID = "Exception_Source_Id";

    public static final String EXCEPTION_CLASS = "Exception_Class";
    public static final String EXCEPTION_CLASS_NAME = "Exception_Class_Name";
    public static final String EXCEPTION_CLASS_OBJECT = "Exception_Class_Object";

    public static final String BANK_INQUIRY_ENTITY = "BANK_INQUIRY_ENTITY";
    public static final String  BANK_INQUIRY_RESPONSE_OBJECT = "BANK_INQUIRY_RESPONSE_OBJECT";

    public static final String REQUEST_OBJECT = "REQUEST_OBJECT";
    public static final String REQUEST_HEADERS = "REQUEST_HEADER";

    public static final Integer EXCEPTION_SOURCE_ID_CARD_CHANNEL = 1;

    public static ResponseDto SUCCESS_RESPONSE_DTO = new ResponseDto(0L, "000","درخواست با موفقیت انجام شد"
            , "Request Approved", new Date()); ;
}
