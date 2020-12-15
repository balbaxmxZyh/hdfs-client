package com.balbaxmx.hdfs.client.model;

import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * @Author: zhangyh
 * @ClassName: HBaseModel
 * @Date: 2020/8/1 21:00
 * @Operation:
 * @Description: ${description}
 */
public class HBaseModel {


    // =============== Put =====================================

    /**
     * 根据rowKey生成一个Put对象
     *
     * @param rowKey rowKey
     * @return Put对象
     */
    public static Put createPut(String rowKey) {
        return new Put(Bytes.toBytes(rowKey));
    }

    // =============== Get =====================================

    /**
     * 根据rowKey生成一个查询的Get对象
     *
     * @param rowKey rowKey
     * @return Get 对象
     */
    public static Get createGet(String rowKey) {
        return new Get(Bytes.toBytes(rowKey));
    }

    // =============== Scan =====================================

    /**
     * 根据startRow和stopRow创建扫描对象
     *
     * @param startRow 扫描开始行，结果包含该行
     * @param stopRow 扫描结束行，结果不包含该行
     * @return Scan对象
     */
    public static Scan createScan(String startRow, String stopRow) {
        Scan scan = new Scan();
        scan.withStartRow(Bytes.toBytes(startRow));
        scan.withStopRow(Bytes.toBytes(stopRow));
        return scan;
    }

    // =============== Delete =====================================

    /**
     * 根据rowKey生成一个查询的Delete对象
     *
     * @param rowKey rowKey
     * @return Delete对象
     */
    public static Delete createDelete(String rowKey) {
        return new Delete(Bytes.toBytes(rowKey));
    }

    /**
     * 生成一个rowkey
     * 按时间逆序
     * @return
     */
    public static String createRowkey(){
        String rowKey = String.valueOf(Long.MAX_VALUE - System.currentTimeMillis());
        System.out.println("rowKey:"+rowKey);
        return rowKey;
    }
}
