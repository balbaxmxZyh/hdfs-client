//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.balbaxmx.kubernetes.client.model.svc;

import com.google.gson.annotations.SerializedName;
import io.kubernetes.client.openapi.models.V1SessionAffinityConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

@ApiModel(
        description = "ServiceSpec describes the attributes that a user creates on a service."
)
public class ServiceSpec {
    public static final String SERIALIZED_NAME_CLUSTER_I_P = "clusterIP";
    @SerializedName("clusterIP")
    private String clusterIP;
    public static final String SERIALIZED_NAME_EXTERNAL_I_PS = "externalIPs";
    @SerializedName("externalIPs")
    private List<String> externalIPs = null;
    public static final String SERIALIZED_NAME_EXTERNAL_NAME = "externalName";
    @SerializedName("externalName")
    private String externalName;
    public static final String SERIALIZED_NAME_EXTERNAL_TRAFFIC_POLICY = "externalTrafficPolicy";
    @SerializedName("externalTrafficPolicy")
    private String externalTrafficPolicy;
    public static final String SERIALIZED_NAME_HEALTH_CHECK_NODE_PORT = "healthCheckNodePort";
    @SerializedName("healthCheckNodePort")
    private Integer healthCheckNodePort;
    public static final String SERIALIZED_NAME_IP_FAMILY = "ipFamily";
    @SerializedName("ipFamily")
    private String ipFamily;
    public static final String SERIALIZED_NAME_LOAD_BALANCER_I_P = "loadBalancerIP";
    @SerializedName("loadBalancerIP")
    private String loadBalancerIP;
    public static final String SERIALIZED_NAME_LOAD_BALANCER_SOURCE_RANGES = "loadBalancerSourceRanges";
    @SerializedName("loadBalancerSourceRanges")
    private List<String> loadBalancerSourceRanges = null;
    public static final String SERIALIZED_NAME_PORTS = "ports";
    @SerializedName("ports")
    private List<ServicePort> ports = null;
    public static final String SERIALIZED_NAME_PUBLISH_NOT_READY_ADDRESSES = "publishNotReadyAddresses";
    @SerializedName("publishNotReadyAddresses")
    private Boolean publishNotReadyAddresses;
    public static final String SERIALIZED_NAME_SELECTOR = "selector";
    @SerializedName("selector")
    private Map<String, String> selector = null;
    public static final String SERIALIZED_NAME_SESSION_AFFINITY = "sessionAffinity";
    @SerializedName("sessionAffinity")
    private String sessionAffinity;
    public static final String SERIALIZED_NAME_SESSION_AFFINITY_CONFIG = "sessionAffinityConfig";
    @SerializedName("sessionAffinityConfig")
    private V1SessionAffinityConfig sessionAffinityConfig;
    public static final String SERIALIZED_NAME_TOPOLOGY_KEYS = "topologyKeys";
    @SerializedName("topologyKeys")
    private List<String> topologyKeys = null;
    public static final String SERIALIZED_NAME_TYPE = "type";
    @SerializedName("type")
    private String type;

    public ServiceSpec() {
    }

    public ServiceSpec clusterIP(String clusterIP) {
        this.clusterIP = clusterIP;
        return this;
    }

    @Nullable
    @ApiModelProperty("clusterIP is the IP address of the service and is usually assigned randomly by the master. If an address is specified manually and is not in use by others, it will be allocated to the service; otherwise, creation of the service will fail. This field can not be changed through updates. Valid values are \"None\", empty string (\"\"), or a valid IP address. \"None\" can be specified for headless services when proxying is not required. Only applies to types ClusterIP, NodePort, and LoadBalancer. Ignored if type is ExternalName. More info: https://kubernetes.io/docs/concepts/services-networking/service/#virtual-ips-and-service-proxies")
    public String getClusterIP() {
        return this.clusterIP;
    }

    public void setClusterIP(String clusterIP) {
        this.clusterIP = clusterIP;
    }

    public ServiceSpec externalIPs(List<String> externalIPs) {
        this.externalIPs = externalIPs;
        return this;
    }

    public ServiceSpec addExternalIPsItem(String externalIPsItem) {
        if (this.externalIPs == null) {
            this.externalIPs = new ArrayList();
        }

        this.externalIPs.add(externalIPsItem);
        return this;
    }

    @Nullable
    @ApiModelProperty("externalIPs is a list of IP addresses for which nodes in the cluster will also accept traffic for this service.  These IPs are not managed by Kubernetes.  The user is responsible for ensuring that traffic arrives at a node with this IP.  A common example is external load-balancers that are not part of the Kubernetes system.")
    public List<String> getExternalIPs() {
        return this.externalIPs;
    }

    public void setExternalIPs(List<String> externalIPs) {
        this.externalIPs = externalIPs;
    }

    public ServiceSpec externalName(String externalName) {
        this.externalName = externalName;
        return this;
    }

    @Nullable
    @ApiModelProperty("externalName is the external reference that kubedns or equivalent will return as a CNAME record for this service. No proxying will be involved. Must be a valid RFC-1123 hostname (https://tools.ietf.org/html/rfc1123) and requires Type to be ExternalName.")
    public String getExternalName() {
        return this.externalName;
    }

    public void setExternalName(String externalName) {
        this.externalName = externalName;
    }

    public ServiceSpec externalTrafficPolicy(String externalTrafficPolicy) {
        this.externalTrafficPolicy = externalTrafficPolicy;
        return this;
    }

    @Nullable
    @ApiModelProperty("externalTrafficPolicy denotes if this Service desires to route external traffic to node-local or cluster-wide endpoints. \"Local\" preserves the client source IP and avoids a second hop for LoadBalancer and Nodeport type services, but risks potentially imbalanced traffic spreading. \"Cluster\" obscures the client source IP and may cause a second hop to another node, but should have good overall load-spreading.")
    public String getExternalTrafficPolicy() {
        return this.externalTrafficPolicy;
    }

    public void setExternalTrafficPolicy(String externalTrafficPolicy) {
        this.externalTrafficPolicy = externalTrafficPolicy;
    }

    public ServiceSpec healthCheckNodePort(Integer healthCheckNodePort) {
        this.healthCheckNodePort = healthCheckNodePort;
        return this;
    }

    @Nullable
    @ApiModelProperty("healthCheckNodePort specifies the healthcheck nodePort for the service. If not specified, HealthCheckNodePort is created by the service api backend with the allocated nodePort. Will use user-specified nodePort value if specified by the client. Only effects when Type is set to LoadBalancer and ExternalTrafficPolicy is set to Local.")
    public Integer getHealthCheckNodePort() {
        return this.healthCheckNodePort;
    }

    public void setHealthCheckNodePort(Integer healthCheckNodePort) {
        this.healthCheckNodePort = healthCheckNodePort;
    }

    public ServiceSpec ipFamily(String ipFamily) {
        this.ipFamily = ipFamily;
        return this;
    }

    @Nullable
    @ApiModelProperty("ipFamily specifies whether this Service has a preference for a particular IP family (e.g. IPv4 vs. IPv6).  If a specific IP family is requested, the clusterIP field will be allocated from that family, if it is available in the cluster.  If no IP family is requested, the cluster's primary IP family will be used. Other IP fields (loadBalancerIP, loadBalancerSourceRanges, externalIPs) and controllers which allocate external load-balancers should use the same IP family.  Endpoints for this Service will be of this family.  This field is immutable after creation. Assigning a ServiceIPFamily not available in the cluster (e.g. IPv6 in IPv4 only cluster) is an error condition and will fail during clusterIP assignment.")
    public String getIpFamily() {
        return this.ipFamily;
    }

    public void setIpFamily(String ipFamily) {
        this.ipFamily = ipFamily;
    }

    public ServiceSpec loadBalancerIP(String loadBalancerIP) {
        this.loadBalancerIP = loadBalancerIP;
        return this;
    }

    @Nullable
    @ApiModelProperty("Only applies to Service Type: LoadBalancer LoadBalancer will get created with the IP specified in this field. This feature depends on whether the underlying cloud-provider supports specifying the loadBalancerIP when a load balancer is created. This field will be ignored if the cloud-provider does not support the feature.")
    public String getLoadBalancerIP() {
        return this.loadBalancerIP;
    }

    public void setLoadBalancerIP(String loadBalancerIP) {
        this.loadBalancerIP = loadBalancerIP;
    }

    public ServiceSpec loadBalancerSourceRanges(List<String> loadBalancerSourceRanges) {
        this.loadBalancerSourceRanges = loadBalancerSourceRanges;
        return this;
    }

    public ServiceSpec addLoadBalancerSourceRangesItem(String loadBalancerSourceRangesItem) {
        if (this.loadBalancerSourceRanges == null) {
            this.loadBalancerSourceRanges = new ArrayList();
        }

        this.loadBalancerSourceRanges.add(loadBalancerSourceRangesItem);
        return this;
    }

    @Nullable
    @ApiModelProperty("If specified and supported by the platform, this will restrict traffic through the cloud-provider load-balancer will be restricted to the specified client IPs. This field will be ignored if the cloud-provider does not support the feature.\" More info: https://kubernetes.io/docs/tasks/access-application-cluster/configure-cloud-provider-firewall/")
    public List<String> getLoadBalancerSourceRanges() {
        return this.loadBalancerSourceRanges;
    }

    public void setLoadBalancerSourceRanges(List<String> loadBalancerSourceRanges) {
        this.loadBalancerSourceRanges = loadBalancerSourceRanges;
    }

    public ServiceSpec ports(List<ServicePort> ports) {
        this.ports = ports;
        return this;
    }

    public ServiceSpec addPortsItem(ServicePort portsItem) {
        if (this.ports == null) {
            this.ports = new ArrayList();
        }

        this.ports.add(portsItem);
        return this;
    }

    @Nullable
    @ApiModelProperty("The list of ports that are exposed by this service. More info: https://kubernetes.io/docs/concepts/services-networking/service/#virtual-ips-and-service-proxies")
    public List<ServicePort> getPorts() {
        return this.ports;
    }

    public void setPorts(List<ServicePort> ports) {
        this.ports = ports;
    }

    public ServiceSpec publishNotReadyAddresses(Boolean publishNotReadyAddresses) {
        this.publishNotReadyAddresses = publishNotReadyAddresses;
        return this;
    }

    @Nullable
    @ApiModelProperty("publishNotReadyAddresses, when set to true, indicates that DNS implementations must publish the notReadyAddresses of subsets for the Endpoints associated with the Service. The default value is false. The primary use case for setting this field is to use a StatefulSet's Headless Service to propagate SRV records for its Pods without respect to their readiness for purpose of peer discovery.")
    public Boolean getPublishNotReadyAddresses() {
        return this.publishNotReadyAddresses;
    }

    public void setPublishNotReadyAddresses(Boolean publishNotReadyAddresses) {
        this.publishNotReadyAddresses = publishNotReadyAddresses;
    }

    public ServiceSpec selector(Map<String, String> selector) {
        this.selector = selector;
        return this;
    }

    public ServiceSpec putSelectorItem(String key, String selectorItem) {
        if (this.selector == null) {
            this.selector = new HashMap();
        }

        this.selector.put(key, selectorItem);
        return this;
    }

    @Nullable
    @ApiModelProperty("Route service traffic to pods with label keys and values matching this selector. If empty or not present, the service is assumed to have an external process managing its endpoints, which Kubernetes will not modify. Only applies to types ClusterIP, NodePort, and LoadBalancer. Ignored if type is ExternalName. More info: https://kubernetes.io/docs/concepts/services-networking/service/")
    public Map<String, String> getSelector() {
        return this.selector;
    }

    public void setSelector(Map<String, String> selector) {
        this.selector = selector;
    }

    public ServiceSpec sessionAffinity(String sessionAffinity) {
        this.sessionAffinity = sessionAffinity;
        return this;
    }

    @Nullable
    @ApiModelProperty("Supports \"ClientIP\" and \"None\". Used to maintain session affinity. Enable client IP based session affinity. Must be ClientIP or None. Defaults to None. More info: https://kubernetes.io/docs/concepts/services-networking/service/#virtual-ips-and-service-proxies")
    public String getSessionAffinity() {
        return this.sessionAffinity;
    }

    public void setSessionAffinity(String sessionAffinity) {
        this.sessionAffinity = sessionAffinity;
    }

    public ServiceSpec sessionAffinityConfig(V1SessionAffinityConfig sessionAffinityConfig) {
        this.sessionAffinityConfig = sessionAffinityConfig;
        return this;
    }

    @Nullable
    @ApiModelProperty("")
    public V1SessionAffinityConfig getSessionAffinityConfig() {
        return this.sessionAffinityConfig;
    }

    public void setSessionAffinityConfig(V1SessionAffinityConfig sessionAffinityConfig) {
        this.sessionAffinityConfig = sessionAffinityConfig;
    }

    public ServiceSpec topologyKeys(List<String> topologyKeys) {
        this.topologyKeys = topologyKeys;
        return this;
    }

    public ServiceSpec addTopologyKeysItem(String topologyKeysItem) {
        if (this.topologyKeys == null) {
            this.topologyKeys = new ArrayList();
        }

        this.topologyKeys.add(topologyKeysItem);
        return this;
    }

    @Nullable
    @ApiModelProperty("topologyKeys is a preference-order list of topology keys which implementations of services should use to preferentially sort endpoints when accessing this Service, it can not be used at the same time as externalTrafficPolicy=Local. Topology keys must be valid label keys and at most 16 keys may be specified. Endpoints are chosen based on the first topology key with available backends. If this field is specified and all entries have no backends that match the topology of the client, the service has no backends for that client and connections should fail. The special value \"*\" may be used to mean \"any topology\". This catch-all value, if used, only makes sense as the last value in the list. If this is not specified or empty, no topology constraints will be applied.")
    public List<String> getTopologyKeys() {
        return this.topologyKeys;
    }

    public void setTopologyKeys(List<String> topologyKeys) {
        this.topologyKeys = topologyKeys;
    }

    public ServiceSpec type(String type) {
        this.type = type;
        return this;
    }

    @Nullable
    @ApiModelProperty("type determines how the Service is exposed. Defaults to ClusterIP. Valid options are ExternalName, ClusterIP, NodePort, and LoadBalancer. \"ExternalName\" maps to the specified externalName. \"ClusterIP\" allocates a cluster-internal IP address for load-balancing to endpoints. Endpoints are determined by the selector or if that is not specified, by manual construction of an Endpoints object. If clusterIP is \"None\", no virtual IP is allocated and the endpoints are published as a set of endpoints rather than a stable IP. \"NodePort\" builds on ClusterIP and allocates a port on every node which routes to the clusterIP. \"LoadBalancer\" builds on NodePort and creates an external load-balancer (if supported in the current cloud) which routes to the clusterIP. More info: https://kubernetes.io/docs/concepts/services-networking/service/#publishing-services-service-types")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ServiceSpec v1ServiceSpec = (ServiceSpec)o;
            return Objects.equals(this.clusterIP, v1ServiceSpec.clusterIP) && Objects.equals(this.externalIPs, v1ServiceSpec.externalIPs) && Objects.equals(this.externalName, v1ServiceSpec.externalName) && Objects.equals(this.externalTrafficPolicy, v1ServiceSpec.externalTrafficPolicy) && Objects.equals(this.healthCheckNodePort, v1ServiceSpec.healthCheckNodePort) && Objects.equals(this.ipFamily, v1ServiceSpec.ipFamily) && Objects.equals(this.loadBalancerIP, v1ServiceSpec.loadBalancerIP) && Objects.equals(this.loadBalancerSourceRanges, v1ServiceSpec.loadBalancerSourceRanges) && Objects.equals(this.ports, v1ServiceSpec.ports) && Objects.equals(this.publishNotReadyAddresses, v1ServiceSpec.publishNotReadyAddresses) && Objects.equals(this.selector, v1ServiceSpec.selector) && Objects.equals(this.sessionAffinity, v1ServiceSpec.sessionAffinity) && Objects.equals(this.sessionAffinityConfig, v1ServiceSpec.sessionAffinityConfig) && Objects.equals(this.topologyKeys, v1ServiceSpec.topologyKeys) && Objects.equals(this.type, v1ServiceSpec.type);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.clusterIP, this.externalIPs, this.externalName, this.externalTrafficPolicy, this.healthCheckNodePort, this.ipFamily, this.loadBalancerIP, this.loadBalancerSourceRanges, this.ports, this.publishNotReadyAddresses, this.selector, this.sessionAffinity, this.sessionAffinityConfig, this.topologyKeys, this.type});
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V1ServiceSpec {\n");
        sb.append("    clusterIP: ").append(this.toIndentedString(this.clusterIP)).append("\n");
        sb.append("    externalIPs: ").append(this.toIndentedString(this.externalIPs)).append("\n");
        sb.append("    externalName: ").append(this.toIndentedString(this.externalName)).append("\n");
        sb.append("    externalTrafficPolicy: ").append(this.toIndentedString(this.externalTrafficPolicy)).append("\n");
        sb.append("    healthCheckNodePort: ").append(this.toIndentedString(this.healthCheckNodePort)).append("\n");
        sb.append("    ipFamily: ").append(this.toIndentedString(this.ipFamily)).append("\n");
        sb.append("    loadBalancerIP: ").append(this.toIndentedString(this.loadBalancerIP)).append("\n");
        sb.append("    loadBalancerSourceRanges: ").append(this.toIndentedString(this.loadBalancerSourceRanges)).append("\n");
        sb.append("    ports: ").append(this.toIndentedString(this.ports)).append("\n");
        sb.append("    publishNotReadyAddresses: ").append(this.toIndentedString(this.publishNotReadyAddresses)).append("\n");
        sb.append("    selector: ").append(this.toIndentedString(this.selector)).append("\n");
        sb.append("    sessionAffinity: ").append(this.toIndentedString(this.sessionAffinity)).append("\n");
        sb.append("    sessionAffinityConfig: ").append(this.toIndentedString(this.sessionAffinityConfig)).append("\n");
        sb.append("    topologyKeys: ").append(this.toIndentedString(this.topologyKeys)).append("\n");
        sb.append("    type: ").append(this.toIndentedString(this.type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}
