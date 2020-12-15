package com.balbaxmx.kubernetes.client.deploy;

import io.kubernetes.client.openapi.models.*;

import java.util.*;

/**
 * @Author: zhangyh
 * @ClassName: YamlInfo
 * @Date: 2020/8/25 13:58
 * @Operation:
 * @Description: 创建yaml文件
 *
 *
 */
public class YamlInfo {

    public static Builder builder(){
        return new YamlInfo.Builder();
    }



    public static class Builder {

        private String kind;

        private String apiVersion;

        private V1ObjectMeta meta;

        private V1DeploymentSpec specBase;

        private Map<String, String> matchLabels;

        private Map<String, String> tempMetaLabel;

        private V1PodSpec podSpec ;

        private List<V1Container> containers;

        private List<V1Volume> volumes;

        private V1PodTemplateSpec templateSpec;

        private V1ObjectMeta objectMeta;

        public Builder setKind(String kind) {
            this.kind = kind;
            return this;
        }

        public Builder setAppVersion(String apiVersion) {
            this.apiVersion = apiVersion;
            return this;
        }

        /**
         * 设置命名空间和deploy名称
         * @param namespace
         * @param deployName
         * @return
         */
        public Builder setMeta(String namespace,String deployName) {
            this.meta.setName(deployName);
            this.meta.setNamespace(namespace);
            return this;
        }

        /**
         * 设置副本数
         * @param replicas
         * @return
         */
        public Builder setReplicas(Integer replicas){
            this.specBase.setReplicas(replicas);
            return this;
        }


        /**
         * 设置 spec.selector.matchLabels
         * @param labelName
         * @param labelValue
         * @return
         */
        public Builder setSelectorMatchLabels(String labelName,String labelValue){
            this.matchLabels.put(labelName,labelValue);
            return this;
        }


        /**
         * 设置 spec.template.metadata.labels
         * @param labelName
         * @param labelValue
         * @return
         */
        public Builder setTempMetaLabel(String labelName,String labelValue){
            this.tempMetaLabel.put(labelName,labelValue);
            return this;
        }

        /**
         * 设置spec.template.spec.containers
         * @param container
         * @return
         */
        public Builder setContainer(V1Container container){
            this.containers.add(container);
            return this;
        }


        /**
         * 设置spec.template.spec.volumes
         * @param volume
         * @return
         */
        public Builder setVolume(V1Volume volume){
            this.volumes.add(volume);
            return this;
        }

        public Builder() {
            this.meta = new V1ObjectMeta();
            this.specBase = new V1DeploymentSpec();
            this.matchLabels = new HashMap<>();
            this.tempMetaLabel = new HashMap<>();
            this.podSpec = new V1PodSpec();
            this.containers = new ArrayList<>();
            this.volumes = new ArrayList<>();
            this.templateSpec = new V1PodTemplateSpec();
            this.objectMeta = new V1ObjectMeta();
            this.kind = "apps/v1";
            this.apiVersion = "Deployment";
        }


        public V1Deployment build() {
            V1Deployment v1Deployment = new V1Deployment();
            V1LabelSelector selector = new V1LabelSelector();
            selector.setMatchLabels(this.matchLabels);
            this.specBase.setSelector(selector);

            this.objectMeta.setLabels(this.tempMetaLabel);
            this.templateSpec.setMetadata(objectMeta);
            this.specBase.setTemplate(templateSpec);

            this.podSpec.setContainers(this.containers);
            this.podSpec.setVolumes(this.volumes);
            this.templateSpec.setSpec(this.podSpec);
            this.specBase.setTemplate(templateSpec);

            v1Deployment.setSpec(this.specBase);
            v1Deployment.setMetadata(this.meta);
            v1Deployment.setApiVersion(this.apiVersion);
            v1Deployment.setKind(this.kind);
            return v1Deployment;
        }
    }
}
