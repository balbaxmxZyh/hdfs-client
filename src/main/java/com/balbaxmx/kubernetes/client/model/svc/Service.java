//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.balbaxmx.kubernetes.client.model.svc;

import com.google.gson.annotations.SerializedName;
import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1Service;
import io.kubernetes.client.openapi.models.V1ServiceStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.annotation.Nullable;

@ApiModel(
        description = "Service is a named abstraction of software service (for example, mysql) consisting of local port (for example 3306) that the proxy listens on, and the selector that determines which pods will answer requests sent through the proxy."
)
public class Service {
    public static final String SERIALIZED_NAME_API_VERSION = "apiVersion";
    @SerializedName("apiVersion")
    private String apiVersion;
    public static final String SERIALIZED_NAME_KIND = "kind";
    @SerializedName("kind")
    private String kind;
    public static final String SERIALIZED_NAME_METADATA = "metadata";
    @SerializedName("metadata")
    private V1ObjectMeta metadata;
    public static final String SERIALIZED_NAME_SPEC = "spec";
    @SerializedName("spec")
    private ServiceSpec spec;
    public static final String SERIALIZED_NAME_STATUS = "status";
    @SerializedName("status")
    private V1ServiceStatus status;

    public Service() {
    }

    public Service apiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    @Nullable
    @ApiModelProperty("APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources")
    public String getApiVersion() {
        return this.apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public Service kind(String kind) {
        this.kind = kind;
        return this;
    }

    @Nullable
    @ApiModelProperty("Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds")
    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Service metadata(V1ObjectMeta metadata) {
        this.metadata = metadata;
        return this;
    }

    @Nullable
    @ApiModelProperty("")
    public V1ObjectMeta getMetadata() {
        return this.metadata;
    }

    public void setMetadata(V1ObjectMeta metadata) {
        this.metadata = metadata;
    }

    public Service spec(ServiceSpec spec) {
        this.spec = spec;
        return this;
    }

    @Nullable
    @ApiModelProperty("")
    public ServiceSpec getSpec() {
        return this.spec;
    }

    public void setSpec(ServiceSpec spec) {
        this.spec = spec;
    }

    public Service status(V1ServiceStatus status) {
        this.status = status;
        return this;
    }

    @Nullable
    @ApiModelProperty("")
    public V1ServiceStatus getStatus() {
        return this.status;
    }

    public void setStatus(V1ServiceStatus status) {
        this.status = status;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Service service = (Service)o;
            return Objects.equals(this.apiVersion, service.apiVersion) && Objects.equals(this.kind, service.kind) && Objects.equals(this.metadata, service.metadata) && Objects.equals(this.spec, service.spec) && Objects.equals(this.status, service.status);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.apiVersion, this.kind, this.metadata, this.spec, this.status});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V1Service {\n");
        sb.append("    apiVersion: ").append(this.toIndentedString(this.apiVersion)).append("\n");
        sb.append("    kind: ").append(this.toIndentedString(this.kind)).append("\n");
        sb.append("    metadata: ").append(this.toIndentedString(this.metadata)).append("\n");
        sb.append("    spec: ").append(this.toIndentedString(this.spec)).append("\n");
        sb.append("    status: ").append(this.toIndentedString(this.status)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
