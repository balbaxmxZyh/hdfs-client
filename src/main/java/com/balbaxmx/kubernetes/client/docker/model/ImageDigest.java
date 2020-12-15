package com.balbaxmx.kubernetes.client.docker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhangyh
 * @ClassName: ImageDigest
 * @Date: 2020/9/7 15:51
 * @Operation:
 * @Description: ${description}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDigest {

    private Integer schemaVersion;

    /**
     * digest值用于删除镜像
     */
    private String digest;
}
