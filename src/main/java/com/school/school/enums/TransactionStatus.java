package com.school.school.enums;

public enum TransactionStatus {


    ACTIVE("ACTIVE"),DEACTIVE("DEACTIVE"),PENDING("PENDING");


    private String code;

    TransactionStatus(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static TransactionStatus getEnum(String code){
        switch (code){
            case "ACTIVE":
                return ACTIVE;
            case "DEACTIVE":
                return DEACTIVE;
            case "PENDING":
                return PENDING;
            default:
                return DEACTIVE;
        }
    }




}
