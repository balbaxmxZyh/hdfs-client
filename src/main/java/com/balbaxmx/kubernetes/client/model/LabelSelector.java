package com.balbaxmx.kubernetes.client.model;

import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangyh
 * @ClassName: LabelSelector
 * @Date: 2020/8/26 16:24
 * @Operation:
 * @Description: ${description}
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LabelSelector {

    private List<LabelSelectorRequirement> matchExpressions;

    private Map<String, String> matchLabels;
}
