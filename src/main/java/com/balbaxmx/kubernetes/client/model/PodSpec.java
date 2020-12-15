package com.balbaxmx.kubernetes.client.model;

import io.kubernetes.client.custom.Quantity;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangyh
 * @ClassName: PodSpec
 * @Date: 2020/8/26 16:42
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PodSpec {
    //todo
    private Long activeDeadlineSeconds;
    private Boolean automountServiceAccountToken;
    private List<Container> containers;
    private String dnsPolicy;
    private Boolean enableServiceLinks;
    private List<HostAlias> hostAliases;
    private Boolean hostIPC;
    private Boolean hostNetwork;
    private Boolean hostPID;
    private String hostname;
    private List<Container> initContainers ;
    private String nodeName;
    private Map<String, String> nodeSelector ;
    private Map<String, Quantity> overhead ;
    private String preemptionPolicy;
    private Integer priority;
    private String priorityClassName;
    private String restartPolicy;
    private String runtimeClassName;
    private String schedulerName;
    private String serviceAccount;
    private Boolean shareProcessNamespace;
    private String subdomain;
    private Long terminationGracePeriodSeconds;
}
