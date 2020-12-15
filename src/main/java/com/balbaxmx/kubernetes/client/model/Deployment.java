package com.balbaxmx.kubernetes.client.model;

import lombok.*;

/**
 * @Author: zhangyh
 * @ClassName: Deployment
 * @Date: 2020/8/26 16:19
 * @Operation:
 * @Description:
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Deployment {

    private String apiVersion;
    private String kind;

    private DeploymentSpec spec;

    private DeploymentStatus status;
}
