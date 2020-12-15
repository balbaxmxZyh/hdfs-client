package com.balbaxmx.kubernetes.client.util;


import io.kubernetes.client.openapi.models.*;

import java.util.*;

/**
 * @Author: zhangyh
 * @ClassName: YamlUtil
 * @Date: 2020/8/19 17:17
 * @Operation:
 * @Description: ${description}
 */
public class YamlUtil {

    /**
     * 创建container
     * @param name containers名称
     * @param image 镜像地址
     * @param imagePullPolicy imagePullPolicy
     * @param commands 启动执行命令
     * @param envVars 设置环境变量
     * @param volumeMounts 需要挂在的目录和名称
     * @return
     */
    public static V1Container createV1Container(String name, String image,
                                                String imagePullPolicy,
                                                List<String> commands,
                                                List<V1EnvVar> envVars,
                                                List<V1VolumeMount> volumeMounts,
                                                List<V1ContainerPort> ports){
        V1Container container = new V1Container();
        container.setName(name);
        container.setImage(image);
        container.setImagePullPolicy(imagePullPolicy);
        container.setCommand(commands);
        container.setEnv(envVars);
        container.setVolumeMounts(volumeMounts);
        container.setPorts(ports);
        return container;
    }

    /**
     * 挂在目录
     * @param name 需要挂在的目录名称（镜像）
     * @param localPath 本地目录（实体机）
     * @param type 类型（""）
     * @return
     */
    public static V1Volume createV1Volume(String name,String localPath,
                                                String type){
        V1Volume volume = new V1Volume();
        V1HostPathVolumeSource source = new V1HostPathVolumeSource();
        source.setPath(localPath);
        source.setType(type);
        volume.setHostPath(source);
        volume.setName(name);
        return volume;
    }

    public static V1Deployment create() {
        V1Deployment deployment = new V1Deployment();
        deployment.setApiVersion("apps/v1");
        deployment.setKind("Deployment");

        V1ObjectMeta meta = new V1ObjectMeta();
        meta.setName("fmcp-sink");
        meta.setNamespace("default");
        deployment.setMetadata(meta);

        //spec
        V1DeploymentSpec specBase = new V1DeploymentSpec();
        specBase.setReplicas(1);
        //spec-selector
        V1LabelSelector selector = new V1LabelSelector();
        //spec-selector-matchLabels
        Map<String, String> matchLabels = new HashMap<>();
        matchLabels.put("test_node", "fmcp-sink");
        selector.setMatchLabels(matchLabels);
        specBase.setSelector(selector);
        //spec-template
        V1PodTemplateSpec template = new V1PodTemplateSpec();
        //spec-template-metadata
        V1ObjectMeta meta1 = new V1ObjectMeta();
        Map<String, String> labels = new HashMap<>();
        labels.put("test_node", "fmcp-sink");
        meta1.setLabels(labels);
        template.setMetadata(meta1);
        //spec-template-spec
        V1PodSpec podSpec = new V1PodSpec();
        //spec-template-spec-containers
        List<V1Container> containers = new ArrayList<>();
        V1Container container1 = new V1Container();
        container1.setName("fmcp-sink");
        container1.setImage("10.1.8.144:5000/fmcp-sink:3.003");
        container1.setImagePullPolicy("IfNotPresent");
        List<String> commands = Arrays.asList("/bin/bash", "-ce",
                "/home/newland/tygj/fmcp/fmcp-collect/fmcp-collect-sink/3.003/fmcp-collect-sink-launch/bin/startup.sh && tail -f /dev/null");
        container1.setCommand(commands);
        List<V1EnvVar> envVars = new ArrayList<>();
        V1EnvVar envVar1 = new V1EnvVar();
        envVar1.setName("author");
        envVar1.setValue("zhangyaohui");
        envVars.add(envVar1);
        container1.setEnv(envVars);
        List<V1VolumeMount> volumeMounts = new ArrayList<>();
        V1VolumeMount mount1 = new V1VolumeMount();
        mount1.setMountPath("/home/newland/tygj/fmcp/fmcp-collect/fmcp-collect-sink/3.003/fmcp-collect-sink-launch/logs");
        mount1.setName("fmcp-sink-logs");
        volumeMounts.add(mount1);
        V1VolumeMount mount2 = new V1VolumeMount();
        mount2.setMountPath("/home/newland/tygj/fmcp/fmcp-collect/fmcp-collect-sink/3.003/fmcp-collect-sink-launch/data");
        mount2.setName("fmcp-sink-data");
        volumeMounts.add(mount2);
        container1.setVolumeMounts(volumeMounts);
        containers.add(container1);
        podSpec.setContainers(containers);

        //spec-template-spec-volumes
        List<V1Volume> volumes = new ArrayList<>();
        V1Volume volume1 = new V1Volume();
        V1HostPathVolumeSource source = new V1HostPathVolumeSource();
        source.setPath("/home/newland/test/logs");
        source.setType("");
        volume1.setHostPath(source);
        volume1.setName("fmcp-sink-logs");
        volumes.add(volume1);

        V1Volume volume2 = new V1Volume();
        V1HostPathVolumeSource source2 = new V1HostPathVolumeSource();
        source2.setPath("/home/newland/test/data");
        source2.setType("");
        volume2.setHostPath(source2);
        volume2.setName("fmcp-sink-data");
        volumes.add(volume2);
        podSpec.setVolumes(volumes);

        //spec-template-spec-volumes
        template.setSpec(podSpec);
        specBase.setTemplate(template);
        deployment.setSpec(specBase);
        return deployment;
    }


}



