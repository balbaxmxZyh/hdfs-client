package com.balbaxmx.kubernetes.client.model;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangyh
 * @ClassName: ObjectMeta
 * @Date: 2020/8/26 16:30
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ObjectMeta {
    private Map<String, String> annotations = null;
    private String clusterName;
    private Date creationTimestamp;
    private Long deletionGracePeriodSeconds;
    private Date deletionTimestamp;
    private List<String> finalizers = null;
    private String generateName;
    private Long generation;
    private Map<String, String> labels = null;
    private List<ManagedFieldsEntry> managedFields = null;
    private String name;
    private String namespace;
    private List<OwnerReference> ownerReferences = null;
    private String resourceVersion;
    private String selfLink;
    private String uid;
}
