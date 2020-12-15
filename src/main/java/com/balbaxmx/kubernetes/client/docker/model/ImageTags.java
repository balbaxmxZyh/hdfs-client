package com.balbaxmx.kubernetes.client.docker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: ImageTags
 * @Date: 2020/9/7 15:07
 * @Operation:
 * @Description: docker镜像版本集合
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageTags {

    private String name;

    private List<String> tags;
}
