package com.school.school.enums;

public enum UserRolesEnum {

    MEMBER("member"),INSTRUCTOR("instructor"),ADMIN("admin");


    private String code;

    UserRolesEnum(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static UserRolesEnum getEnum(String code){
        switch (code){
            case "member":
                return MEMBER;
            case "instructor":
                return INSTRUCTOR;
            case "admin":
                return ADMIN;
            default:
                return MEMBER;
        }
    }

}
