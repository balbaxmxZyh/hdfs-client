package com.balbaxmx.kubernetes.client.model;

import lombok.*;

import java.util.Date;

/**
 * @Author: zhangyh
 * @ClassName: ManagedFieldsEntry
 * @Date: 2020/8/26 16:47
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ManagedFieldsEntry {

    private String apiVersion;
    private String fieldsType;
    private Object fieldsV1;
    private String manager;
    private String operation;
    private Date time;
}
