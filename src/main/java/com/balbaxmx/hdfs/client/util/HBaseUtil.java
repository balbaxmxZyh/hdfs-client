package com.balbaxmx.hdfs.client.util;

import com.balbaxmx.hdfs.client.model.HBaseModel;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangyh
 * @ClassName: HBaseUtil
 * @Date: 2020/7/26 16:26
 * @Operation:
 * @Description: ${description}
 */
public class HBaseUtil {
    private static Logger logger = LoggerFactory.getLogger(HBaseUtil.class);

    private static Configuration configuration = null;

    private static Connection connection;

    private static Admin admin;
    static {
        String zkHost = "192.168.2.177:2181,192.168.2.178:2181,192.168.2.179:2181";
        configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum",zkHost);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        try {
            connection = ConnectionFactory.createConnection(configuration,executor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取admin对象 创建、删除表
     * @return
     */
    public static Admin getAdmin(){
        if(admin != null){
            return admin;
        }
        try {
            admin = connection.getAdmin();
        } catch (IOException e) {
            logger.info("创建admin 失败[{}]",e);
        }
        return admin;
    }

    /**
     * 关闭连接
     * @throws Exception
     */
    public void close() throws Exception{
        if(admin != null){
            admin.close();
        }
        if(connection != null){
            connection.close();
        }
    }

    /**
     * 创建表
     * @param name 表名
     * @param familys 列簇
     * @return
     */
    public static boolean createTable(String name,String...familys){
       return createTable(name,null,familys);
    }

    /**
     * 创建表
     * @param name 表名
     * @param splitKeys region
     *
                byte[][] splitKeys = new byte[][] { Bytes.toBytes("100000"),
                Bytes.toBytes("200000"), Bytes.toBytes("400000"),
                Bytes.toBytes("500000") };

    String[] keys = new String[]{"10|","20|","30|","40|","50|","60|","70|","80|","90|"};
    byte[][] splitKeys = new byte[keys.length][];

     * @param familys 列簇
     * @return
     */
    public static boolean createTable(String name, byte[][] splitKeys,String... familys){
        TableName tname=TableName.valueOf(name);
        try {
            //todo 超时未知原因
            /*if(getAdmin().tableExists(tname)){
                logger.error("表已经存在[{}]",name);
                return false;
            }*/
            TableDescriptorBuilder tdesc=TableDescriptorBuilder.newBuilder(tname);
            for(String s: familys){
                ColumnFamilyDescriptor cfd=ColumnFamilyDescriptorBuilder.of(s);
                tdesc.setColumnFamily(cfd);
            }
            TableDescriptor desc=tdesc.build();
            if(splitKeys == null || splitKeys.length < 1){
                getAdmin().createTable(desc);
            }else {
                getAdmin().createTable(desc,splitKeys);
            }
        }catch (Exception e){
            logger.error("{}",e);
            return false;
        }
        return true;
    }

    /**
     * 删除表
     * @param name 表名
     * @throws IOException
     * */
    public void deleteTable(String name) throws IOException{
        TableName tableName=TableName.valueOf(name);
        getAdmin().disableTable(tableName);
        getAdmin().deleteTable(tableName);
    }

    /**
     * 根据表名获取Table对象
     *
     * @param name 表名，必要时可指定命名空间，比如：“default:user”
     * @return Hbase Table 对象
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static Table getTable(String name) throws IOException {
        TableName tableName = TableName.valueOf(name);
        return connection.getTable(tableName);
    }


    /**
     * 在Put对象上增加Cell
     *
     * @param put Put对象
     * @param cell cell对象
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static void addCellOnPut(Put put, Cell cell) throws IOException {
        put.add(cell);
    }

    /**
     * 在Put对象上增加值
     *
     * @param put Put对象
     * @param family 列簇
     * @param qualifier 列
     * @param value 字符串类型的值
     */
    public static void addValueOnPut(Put put, String family, String qualifier, String value) {
        addValueOnPut(put, family, qualifier, Bytes.toBytes(value));
    }

    /**
     * 在Put对象上增加值
     *
     * @param put Put对象
     * @param family 列簇
     * @param qualifier 列
     * @param value 字节数组类型的值，可以是任意对象序列化而成
     */
    public static void addValueOnPut(Put put, String family, String qualifier, byte[] value) {
        put.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier), value);
    }

    /**
     * 在Put对象上增加值
     *
     * @param put Put对象
     * @param family 列簇
     * @param qualifier 列
     * @param ts Timestamp时间戳
     * @param value 字符串类型的值
     */
    public static void addValueOnPut(Put put, String family, String qualifier, long ts, String value) {
        addValueOnPut(put, family, qualifier, ts, Bytes.toBytes(value));
    }

    /**
     * 在Put对象上增加值
     *
     * @param put Put对象
     * @param family 列簇
     * @param qualifier 列
     * @param ts Timestamp时间戳
     * @param value 字节数组类型的值，可以是任意对象序列化而成
     */
    public static void addValueOnPut(Put put, String family, String qualifier, long ts, byte[] value) {
        put.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier), ts, value);
    }

    /**
     * 按表名插入一个Put对象包含的数据
     *
     * @param tableName 表名，必要时可指定命名空间，比如：“default:user”
     * @param put 要插入的数据对象
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static void put(String tableName, Put put) throws IOException {
        try (
                Table table = getTable(tableName);
        ) {

            table.put(put);
        }
    }

    /**
     * 按表名批量插入Put对象包含的数据
     *
     * @param tableName 表名，必要时可指定命名空间，比如：“default:user”
     * @param puts 要插入的数据对象集合
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static void put(String tableName, List<Put> puts) throws IOException {
        try (Table table = getTable(tableName)){
            table.put(puts);
        }
    }


    /**
     * 对查询的Get对象增加指定列簇
     *
     * @param get
     * @param family
     */
    public static void addFamilyOnGet(Get get, String family) {
        get.addFamily(Bytes.toBytes(family));
    }

    /**
     * 对查询的Get对象增加指定列簇和列
     *
     * @param get
     * @param family
     * @param qualifier
     */
    public static void addColumnOnGet(Get get, String family, String qualifier) {
        get.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier));
    }

    /**
     * 根据表名和rowKey查询结果（包含全部列簇和列）
     *
     * @param tableName 表名，必要时可指定命名空间，比如：“default:user”
     * @param rowKey 查询rowKey
     * @return 查询结果Result
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static Result get(String tableName, String rowKey) throws IOException {
        Get get = HBaseModel.createGet(rowKey);
        return get(tableName, get);
    }

    /**
     * 根据表名和rowKey数组批量查询结果（包含全部列簇和列）
     *
     * @param tableName 表名，必要时可指定命名空间，比如：“default:user”
     * @param rowKeys 查询rowKey数组
     * @return 查询结果Result数组
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static Result[] get(String tableName, String[] rowKeys) throws IOException {
        List<Get> gets = new ArrayList<>();
        for (String rowKey : rowKeys) {
            gets.add(HBaseModel.createGet(rowKey));
        }
        return get(tableName, gets);
    }

    /**
     * 根据表名和Get对象查询结果
     *
     * @param tableName 表名，必要时可指定命名空间，比如：“default:user”
     * @param get Hbase查询对象
     * @return 查询结果Result
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static Result get(String tableName, Get get) throws IOException {
        try (
                Table table = getTable(tableName);
        ) {

            return table.get(get);
        }
    }

    /**
     * 根据表名和Get对象数组查询结果
     *
     * @param tableName 表名，必要时可指定命名空间，比如：“default:user”
     * @param gets 多个Hbase查询对象组成的数组
     * @return 查询结果Result数组
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static Result[] get(String tableName, List<Get> gets) throws IOException {
        try (
                Table table = getTable(tableName);
        ) {
            return table.get(gets);
        }
    }


    /**
     * 对扫描对象设置列簇
     *
     * @param scan 扫描对象
     * @param family 列簇
     */
    public static void addFamilyOnScan(Scan scan, String family) {
        scan.addFamily(Bytes.toBytes(family));
    }

    /**
     * 对扫描对象设置列
     *
     * @param scan 扫描对象
     * @param family 列簇
     * @param qualifier 列簇下对应的列
     */
    public static void addColumnOnScan(Scan scan, String family, String qualifier) {
        scan.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier));
    }

    /**
     * 根据表名和扫描对象扫描数据
     *
     * @param tableName 表名，必要时可指定命名空间，比如：“default:user”
     * @param scan 扫描对象
     * @return 扫描结果集对象ResultScanner
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static ResultScanner scan(String tableName, Scan scan) throws IOException {
        try (
                Table table = getTable(tableName);
        ) {
            return table.getScanner(scan);
        }
    }

    /**
     * 根据表名、开始行和结束行扫描数据（结果包含开始行，不包含结束行，半开半闭区间[startRow, stopRow)）
     *
     * @param tableName 表名，必要时可指定命名空间，比如：“default:user”
     * @param startRow 扫描开始行
     * @param stopRow 扫描结束行
     * @return 扫描结果集对象ResultScanner
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static ResultScanner scan(String tableName, String startRow, String stopRow) throws IOException {
        return scan(tableName, HBaseModel.createScan(startRow, stopRow));
    }


    /**
     * 在Delete对象上增加Cell
     *
     * @param delete Delete对象
     * @param cell cell对象
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static void addCellOnDelete(Delete delete, Cell cell) throws IOException {
        delete.add(cell);
    }

    /**
     * 对删除对象增加指定列簇
     *
     * @param delete Delete对象
     * @param family 列簇
     */
    public static void addFamilyOnDelete(Delete delete, String family) {
        delete.addFamily(Bytes.toBytes(family));
    }

    /**
     * 对删除对象增加指定列簇和列
     *
     * @param delete Delete对象
     * @param family 列簇
     * @param qualifier 列
     */
    public static void addColumnOnDelete(Delete delete, String family, String qualifier) {
        delete.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier));
    }

    /**
     * 按表名删除一个Delete对象指定的数据
     *
     * @param tableName 表名，必要时可指定命名空间，比如：“default:user”
     * @param delete Delete对象
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static void delete(String tableName, Delete delete) throws IOException {
        try (
                Table table = getTable(tableName)
        ) {
            table.delete(delete);
        }
    }

    /**
     * 按表名批量删除Delete对象集合包含的指定数据
     *
     * @param tableName 表名，必要时可指定命名空间，比如：“default:user”
     * @param deletes Delete对象集合
     * @throws IOException 有异常抛出，由调用者捕获处理
     */
    public static void delete(String tableName, List<Delete> deletes) throws IOException {
        try (
                Table table = getTable(tableName);
        ) {
            table.delete(deletes);
        }
    }


    /*public static HConnection getConnection() {
        if (null == connection){
            synchronized (lock) {
                if (null == connection) {//空的时候创建，不为空就直接返回；典型的单例模式
                    Configuration conf = HBaseConfiguration.create();
                    String zkHost = "mpc5:2181,mpc6:2181,mpc7:2181";
                    conf.set("hbase.zookeeper.quorum", zkHost);
                    ExecutorService pool = Executors.newFixedThreadPool(10);//建立一个数量为10的线程池
                    try {
                        connection = HConnectionManager.createConnection(conf, pool);//用线程池创建connection
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
    }*/
}
