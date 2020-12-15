package com.balbaxmx.common.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: BatchLine
 * @Date: 2020/9/2 14:44
 * @Operation:
 * @Description: 每个批次对于的数据
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchLine {

    /**
     * 批次号
     */
    private Integer batchNum;

    /**
     * 行数据
     */
    private List<String> lines;
}
