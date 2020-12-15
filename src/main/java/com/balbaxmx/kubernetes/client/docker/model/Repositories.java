package com.balbaxmx.kubernetes.client.docker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: Repositories
 * @Date: 2020/9/7 14:57
 * @Operation:
 * @Description: docker镜像集合
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repositories {

    private List<String> repositories;
}
