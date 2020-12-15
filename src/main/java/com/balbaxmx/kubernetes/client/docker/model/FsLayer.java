package com.balbaxmx.kubernetes.client.docker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhangyh
 * @ClassName: FsLayer
 * @Date: 2020/9/7 15:32
 * @Operation:
 * @Description: 镜像digest信息用于删除
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FsLayer {
    private String blobSum;
}
