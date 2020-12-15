package com.balbaxmx.kubernetes.client.model;

import lombok.*;

import java.util.Date;

/**
 * @Author: zhangyh
 * @ClassName: DeploymentCondition
 * @Date: 2020/8/26 16:50
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeploymentCondition {
    private Date lastTransitionTime;
    private Date lastUpdateTime;
    private String message;
    private String reason;
    private String status;
    private String type;

}
