package com.balbaxmx.kubernetes.client.patch;

import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: JsonPathInfo
 * @Date: 2020/8/25 21:22
 * @Operation:
 * @Description: jsonPath格式
 */
public class JsonPathInfo {

    private String opValue;

    private Object value;

    private PatchEnum patchEnum;


    public JsonPathInfo(String opValue, Object value,PatchEnum patchEnum) {
        this.opValue = opValue;
        this.value = value;
        this.patchEnum = patchEnum;
    }

    public String getOpValue() {
        return opValue;
    }

    public void setOpValue(String opValue) {
        this.opValue = opValue;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public PatchEnum getPatchEnum() {
        return patchEnum;
    }

    public void setPatchEnum(PatchEnum patchEnum) {
        this.patchEnum = patchEnum;
    }

    public String toJsonPath(){
        StringBuilder builder = new StringBuilder("{");
        builder.append("\"op\"").append(":");
        builder.append("\"").append(patchEnum.getOp()).append("\"").append(",");
        builder.append("\"").append(patchEnum.getLogo()).append("\"").append(":");
        builder.append("\"").append(opValue).append("\"");
        if(!StringUtils.isEmpty(patchEnum.getValue())){
            builder.append(",");
            builder.append("\"").append(patchEnum.getValue()).append("\"").append(":");
            if(value instanceof String) {
                builder.append("\"").append((String)value).append("\"");
            }else if(value instanceof Integer){
                builder.append(value);
            }else if(value instanceof List){
                List list = (List) value;
                builder.append(list.toString());
            }else {
                builder.append("\"").append(value.toString()).append("\"");
            }
        }
        builder.append("}");
        return builder.toString();
    }
}
