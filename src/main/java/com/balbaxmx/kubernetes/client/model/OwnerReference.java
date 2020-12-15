package com.balbaxmx.kubernetes.client.model;

import lombok.*;

/**
 * @Author: zhangyh
 * @ClassName: OwnerReference
 * @Date: 2020/8/26 16:48
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OwnerReference {
    private String apiVersion;
    private Boolean blockOwnerDeletion;
    private Boolean controller;
    private String kind;
    private String name;
    private String uid;
}
