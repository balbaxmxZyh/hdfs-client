package com.balbaxmx.kubernetes.client.model;

import lombok.*;

import javax.ws.rs.GET;
import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: LabelSelectorRequirement
 * @Date: 2020/8/26 16:24
 * @Operation:
 * @Description: ${description}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LabelSelectorRequirement {
    private String key;
    private String operator;
    private List<String> values = null;
}
