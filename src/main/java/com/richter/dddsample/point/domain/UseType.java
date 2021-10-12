package com.richter.dddsample.point.domain;

public enum UseType {
    /** 付与 */ Add("add", "付与"),
    /** 使用 */ Use("use", "使用"),
    /** 失効 */ Expired("exp", "失効"),
    /** 統合 */ Consolidate("con", "統合");

    /** コード値 */
    private String code;
    /** コード名 */
    private String name;

    UseType(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public String getCode() {
        return this.code;
    }
    public String getName() {
        return this.name;
    }
}
