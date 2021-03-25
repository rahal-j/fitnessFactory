package com.school.school.enums;

public enum ResponseEnum {

    SUCCESS("SUCCESS","Transaction Completed Successfully"),FAIL("FAIL","Transaction Failed");

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }



    ResponseEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }


    public static ResponseEnum getEnum(String code,String msg){
        switch (code){
            case "SUCCESS":
                return SUCCESS;
            case "FAIL":
                return FAIL;
            default:
                return null;
        }
    }
}
