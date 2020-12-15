package com.balbaxmx.common.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhangyh
 * @ClassName: BatchInfo
 * @Date: 2020/8/18 15:58
 * @Operation:
 * @Description: 分批次读取文件，每批次的信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchInfo {

    /**
     * 开始字节位置
     */
    private Long start;

    /**
     * 结束字节位置
     */
    private Long end;

}
