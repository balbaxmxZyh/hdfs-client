package com.balbaxmx.hdfs.client.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @Author: zhangyh
 * @ClassName: TestMapper
 * @Date: 2020/8/12 9:46
 * @Operation:
 * @Description:

 * KEYIN：输入的key的类型
 * VALUEIN：输入的value的类型
 * KEYOUT：输出的key的数据类型
 * VALUEOUT：输出的value的数据累心
 * map reduce的数据输入输出都是以key,value对封装的
 * 至于输入的key,value形式我们是不能控制的,是框架传给我们的,
 * 框架传给我们是什么类型,我们这里就写什么数据类型

 * Mapper<Long, String, String, int>
 * 但是不管是Long还是String,在MapReduce里面运行的时候,这个数据读到网络里面进行传递
 * 即各个节点之间会进行传递,那么要在网络里面传输,那么就意味着这个数据得序列化
 * Long、String对象，内存对象走网络都得序列化,Long、String,int序列化
 * 如果自己实现Serializable接口，那么附加的信息太多了
 * hadoop实现了自己的一套序列化机制
 * 所以就不要用Java里面的数据类型了，而是用它自己的封装一套数据类型
 * 这样就有助于提高效率,实现了自己的序列化接口
 * 在序列化传输的 时候走的就是自己的序列化方法来传递,少了很多负载信息,传递数据精简,
 * Long---LongWritable
 * String也有自己的封装-Text
 * int--IntWritable
 */
public class TestMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

    /**
     *  具体的逻辑分解
     * @param key 这一行数据的其实偏移量
     * @param value 这一行数据的文本内容
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        //1.先把单词拿出来,拿到一行
        String line = value.toString();
        //2.切分单词,这个是按照特定的分隔符 进行切分
        String [] words = line.split(" ");
        /*
        3.把里面的单词发送出去
        遍历单词数组,输出为<K,V>形式 key是单词,value是1
        */
        for (String word : words) {
            //记得把key和value继续封装起来,即下面
            context.write(new Text(word), new IntWritable(1));
        }


        /*
         * map方法的执行频率：每读一行就调一次
         * 最后到reduce 的时候，应该是把某个单词里面所有的1都到，才能处理
         * 而且中间有一个缓存的过程,因为每个map的处理速度都不会完全一致
         * 等那个单词所有的1都到齐了才传给reduce
         */
        //每一组key,value都全了，才会去调用一次reduce，reduce直接去处理valuelist
        //接着就是写Reduce逻辑了

    }
}
