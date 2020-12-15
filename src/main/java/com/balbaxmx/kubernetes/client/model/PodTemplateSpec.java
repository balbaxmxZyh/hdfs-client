package com.balbaxmx.kubernetes.client.model;

import lombok.*;

/**
 * @Author: zhangyh
 * @ClassName: PodTemplateSpec
 * @Date: 2020/8/26 16:30
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PodTemplateSpec {
    private ObjectMeta metadata;
    private PodSpec spec;
}
