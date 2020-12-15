package com.balbaxmx.kubernetes.client.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: DeploymentList
 * @Date: 2020/8/26 17:10
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeploymentList {
    private String apiVersion;
    private List<Deployment> items = new ArrayList<>();
    private String kind;
}
