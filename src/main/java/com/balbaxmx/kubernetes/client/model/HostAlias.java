package com.balbaxmx.kubernetes.client.model;

import lombok.*;

import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: HostAlias
 * @Date: 2020/8/26 16:56
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HostAlias {
    private List<String> hostnames;
    private String ip;
}
