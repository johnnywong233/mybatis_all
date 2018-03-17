package com.johnny.pojo;

public enum SexEnum {

    SEX_MALE("男"),//男
    SEX_FEMALE("女"),//女
    SEX_UNKNOWN("未知");
    private final String text;

    SexEnum(final String text) {
        this.text = text;
    }

    public static String index(Integer index) {
        switch (index) {
            case 1:
                return SexEnum.SEX_MALE.toString();
            case 2:
                return SexEnum.SEX_FEMALE.toString();
            default:
                return SexEnum.SEX_UNKNOWN.toString();
        }
    }

    public static SexEnum entity(Integer index) {
        switch (index) {
            case 1:
                return SexEnum.SEX_MALE;
            case 2:
                return SexEnum.SEX_FEMALE;
            default:
                return SexEnum.SEX_UNKNOWN;
        }
    }

    @Override
    public String toString() {
        return text;
    }

}