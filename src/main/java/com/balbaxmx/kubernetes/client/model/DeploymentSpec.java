package com.balbaxmx.kubernetes.client.model;

import io.kubernetes.client.openapi.models.V1PodTemplateSpec;
import lombok.*;

/**
 * @Author: zhangyh
 * @ClassName: DeploymentSpec
 * @Date: 2020/8/26 16:20
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeploymentSpec {

    private Integer minReadySeconds;
    private Boolean paused;
    private Integer progressDeadlineSeconds;
    private Integer replicas;
    private Integer revisionHistoryLimit;
    private LabelSelector selector;
    private DeploymentStrategy strategy;
    private PodTemplateSpec template;
}
