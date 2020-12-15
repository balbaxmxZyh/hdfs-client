package com.balbaxmx.kubernetes.client.model.svc;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * @Author: zhangyh
 * @ClassName: ServicePort
 * @Date: 2020/8/27 11:23
 * @Operation:
 * @Description: ${description}
 */
public class ServicePort {
    public static final String SERIALIZED_NAME_NAME = "name";
    @SerializedName("name")
    private String name;
    public static final String SERIALIZED_NAME_NODE_PORT = "nodePort";
    @SerializedName("nodePort")
    private Integer nodePort;
    public static final String SERIALIZED_NAME_PORT = "port";
    @SerializedName("port")
    private Integer port;
    public static final String SERIALIZED_NAME_PROTOCOL = "protocol";
    @SerializedName("protocol")
    private String protocol;
    public static final String SERIALIZED_NAME_TARGET_PORT = "targetPort";
    @SerializedName("targetPort")
    private Integer targetPort;

    public ServicePort() {
    }

    public ServicePort name(String name) {
        this.name = name;
        return this;
    }

    @Nullable
    @ApiModelProperty("The name of this port within the service. This must be a DNS_LABEL. All ports within a ServiceSpec must have unique names. When considering the endpoints for a Service, this must match the 'name' field in the EndpointPort. Optional if only one ServicePort is defined on this service.")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServicePort nodePort(Integer nodePort) {
        this.nodePort = nodePort;
        return this;
    }

    @Nullable
    @ApiModelProperty("The port on each node on which this service is exposed when type=NodePort or LoadBalancer. Usually assigned by the system. If specified, it will be allocated to the service if unused or else creation of the service will fail. Default is to auto-allocate a port if the ServiceType of this Service requires one. More info: https://kubernetes.io/docs/concepts/services-networking/service/#type-nodeport")
    public Integer getNodePort() {
        return this.nodePort;
    }

    public void setNodePort(Integer nodePort) {
        this.nodePort = nodePort;
    }

    public ServicePort port(Integer port) {
        this.port = port;
        return this;
    }

    @ApiModelProperty(
            required = true,
            value = "The port that will be exposed by this service."
    )
    public Integer getPort() {
        return this.port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public ServicePort protocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    @Nullable
    @ApiModelProperty("The IP protocol for this port. Supports \"TCP\", \"UDP\", and \"SCTP\". Default is TCP.")
    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public ServicePort targetPort(Integer targetPort) {
        this.targetPort = targetPort;
        return this;
    }

    @Nullable
    @ApiModelProperty("IntOrString is a type that can hold an int32 or a string.  When used in JSON or YAML marshalling and unmarshalling, it produces or consumes the inner type.  This allows you to have, for example, a JSON field that can accept a name or number.")
    public Integer getTargetPort() {
        return this.targetPort;
    }

    public void setTargetPort(Integer targetPort) {
        this.targetPort = targetPort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ServicePort v1ServicePort = (ServicePort)o;
            return Objects.equals(this.name, v1ServicePort.name) && Objects.equals(this.nodePort, v1ServicePort.nodePort) && Objects.equals(this.port, v1ServicePort.port) && Objects.equals(this.protocol, v1ServicePort.protocol) && Objects.equals(this.targetPort, v1ServicePort.targetPort);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.nodePort, this.port, this.protocol, this.targetPort});
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V1ServicePort {\n");
        sb.append("    name: ").append(this.toIndentedString(this.name)).append("\n");
        sb.append("    nodePort: ").append(this.toIndentedString(this.nodePort)).append("\n");
        sb.append("    port: ").append(this.toIndentedString(this.port)).append("\n");
        sb.append("    protocol: ").append(this.toIndentedString(this.protocol)).append("\n");
        sb.append("    targetPort: ").append(this.toIndentedString(this.targetPort)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }

}
