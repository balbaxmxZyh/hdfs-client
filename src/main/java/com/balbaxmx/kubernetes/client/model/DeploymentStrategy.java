package com.balbaxmx.kubernetes.client.model;

import lombok.*;

/**
 * @Author: zhangyh
 * @ClassName: DeploymentStrategy
 * @Date: 2020/8/26 16:26
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeploymentStrategy {

    private RollingUpdateDeployment rollingUpdate;

    private String type;
}
