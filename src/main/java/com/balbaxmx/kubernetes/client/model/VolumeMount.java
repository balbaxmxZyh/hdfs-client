package com.balbaxmx.kubernetes.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: zhangyh
 * @ClassName: VolumeMount
 * @Date: 2020/8/26 17:03
 * @Operation:
 * @Description: ${description}
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VolumeMount {
    private String mountPath;
    private String mountPropagation;
    private String name;
    private Boolean readOnly;
    private String subPath;
    private String subPathExpr;
}
