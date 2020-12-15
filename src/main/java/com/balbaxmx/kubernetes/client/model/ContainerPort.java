package com.balbaxmx.kubernetes.client.model;

import lombok.*;

/**
 * @Author: zhangyh
 * @ClassName: ContainerPort
 * @Date: 2020/8/26 17:02
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContainerPort {
    private Integer containerPort;
    private String hostIP;
    private Integer hostPort;
    private String name;
    private String protocol;
}
