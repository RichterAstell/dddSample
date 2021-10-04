package com.richter.dddsample.customer.domain;

public enum Gender {
    /** 不明 */ NOT_KNOWN(0, "不明"),
    /** 男性 */ MALE(1, "男性"),
    /** 女性 */ FEMALE(2, "女性"),
    /** 適用不能 */ NOT_APPLICABLE(9, "適用不能");

    /** コード値 */
    private int code;
    /** コード名 */
    private String name;

    Gender(int code, String name) {
        this.code = code;
        this.name = name;
    }
    public Integer getCode() {
        return this.code;
    }
    public String getName() {
        return this.name;
    }
}
