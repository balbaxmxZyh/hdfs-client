package com.balbaxmx.kubernetes.client.patch;

/**
 * @Author: zhangyh
 * @ClassName: PatchEnum
 * @Date: 2020/8/25 21:25
 * @Operation:
 * @Description: jsonPath 操作
 *
 *
 */
public enum PatchEnum {
    REPLACE("replace", "path","value"),
    ADD("add", "path","value"),
    REMOVE("remove", "path",""),
    COPY("copy", "from","path"),
    MOVE("move", "from","path");

    private String op;

    private String logo;

    private String value;

    private PatchEnum(String op, String logo, String value) {
        this.op = op;
        this.logo = logo;
        this.value = value;
    }

    public String getOp() {
        return op;
    }

    public String getLogo() {
        return logo;
    }

    public String getValue() {
        return value;
    }
}
