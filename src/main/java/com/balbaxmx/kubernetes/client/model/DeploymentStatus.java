package com.balbaxmx.kubernetes.client.model;

import io.kubernetes.client.openapi.models.V1DeploymentCondition;
import lombok.*;

import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: DeploymentStatus
 * @Date: 2020/8/26 16:49
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeploymentStatus {
    private Integer availableReplicas;
    private Integer collisionCount;
    private List<DeploymentCondition> conditions;
    private Long observedGeneration;
    private Integer readyReplicas;
    private Integer replicas;
    private Integer unavailableReplicas;
    private Integer updatedReplicas;
}
