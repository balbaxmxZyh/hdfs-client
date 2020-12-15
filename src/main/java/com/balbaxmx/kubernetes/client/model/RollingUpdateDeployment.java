package com.balbaxmx.kubernetes.client.model;


import lombok.*;

/**
 * @Author: zhangyh
 * @ClassName: RollingUpdateDeployment
 * @Date: 2020/8/26 16:27
 * @Operation:
 * @Description: ${description}
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RollingUpdateDeployment {

    private String maxSurge;
    private String maxUnavailable;
}
