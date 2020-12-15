package com.balbaxmx.hdfs.client.reduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Author: zhangyh
 * @ClassName: TestReduce
 * @Date: 2020/8/12 9:53
 * @Operation:
 * @Description:
 *
 *  前两个泛型类型：由map输出的类型决定<text，intWritable>【<KEY,VALUE>】，<hello,1>
 *
 *
 *  后两个泛型：
 *
 *
 * 框架在map处理完成之后,将所有的KV对保存起来,进行分组,然后传递一个组,调用一次reduce
 * 相同的key在一个组
 */
public class TestReduce extends Reducer<Text,IntWritable,Text,Text> {


    /**
     * map
     * @param key map输出的key（字段）
     * @param values map输出的value（出现的列表）
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        //遍历valuelist，进行了累加
        int count = 0;
        for (IntWritable value : values) {
            //get()方法就能拿到里面的值
            count += value.get();
        }
        //输出一组(一个单词)的统计结果
        //默认输出到HDFS的一个文件上面去,放在HDFS的某个目录下
        context.write(key, new Text(count+""));


        /*
         * Map，Reducce都是个分散的,那集群运行的时候不知道运行哪些MapReduce
         *
         * 处理业务逻辑的一个整体，叫做job
         * 我们就可以把那个job告诉那个集群,我们此次运行的是哪个job,
         * job里面用的哪个作为Mapper，哪个业务作为Reducer，我们得指定
         *
         * 所以还得写一个类用来描述处理业务逻辑
         * 把一个特定的业务处理逻辑叫做一个job(作业),我们就可以把这个job告诉那个集群,
         *
         */
    }
}
