package com.balbaxmx.kubernetes.client.model;

import lombok.*;

import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: Container
 * @Date: 2020/8/26 16:52
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Container {
    private List<String> args = null;
    private List<String> command = null;
    private String image;
    private String imagePullPolicy;
    private String name;
    private List<ContainerPort> ports = null;
    private Boolean stdin;
    private Boolean stdinOnce;
    private String terminationMessagePath;
    private String terminationMessagePolicy;
    private Boolean tty;
    private List<VolumeMount> volumeMounts = null;
    private String workingDir;
}
